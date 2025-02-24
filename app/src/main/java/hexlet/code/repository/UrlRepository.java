package hexlet.code.repository;

import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static hexlet.code.repository.BaseRepository.dataSource;

public class UrlRepository {
    public static void save(Url url) throws SQLException {
        String sql = "INSERT INTO urls (name, created_at) VALUES (?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, url.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                url.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Url> find(Long id) throws SQLException {
        var sql = "SELECT * FROM urls WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var created = resultSet.getTimestamp("created_at");
                var url = new Url(name);
                url.setCreatedAt(created.toLocalDateTime());
                url.setId(id);
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }

    public static Optional<Url> findName(String name) throws SQLException {
        var sql = "SELECT * FROM urls WHERE name = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var id = resultSet.getLong("id");
                var created = resultSet.getTimestamp("created_at");
                var url = new Url(name);
                url.setCreatedAt(created.toLocalDateTime());
                url.setId(id);
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }

    public static List<Url> getEntities() throws SQLException {
        var sql = "SELECT urls.id, urls.name, " +
                "COALESCE(url_checks.status_code, 0) AS status_code, " +
                "COALESCE(url_checks.created_at, CURRENT_TIMESTAMP) AS last " +
                "FROM urls " +
                "LEFT JOIN url_checks ON urls.id = url_checks.url_id " +
                "ORDER BY urls.created_at DESC";

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<Url>();

            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var statusCode = resultSet.getInt("status_code");
                var lastCheckTimestamp = resultSet.getTimestamp("last");

                var url = new Url(name);
                url.setId(id);

                if (statusCode != 0) {
                    UrlCheck urlCheck = new UrlCheck();
                    urlCheck.setUrlId(id);
                    urlCheck.setStatusCode(statusCode);
                    urlCheck.setCreatedAt(lastCheckTimestamp.toLocalDateTime());
                    url.setLastCheck(urlCheck);
                }

                result.add(url);
            }
            return result;
        }
    }

}
