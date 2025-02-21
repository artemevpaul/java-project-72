package hexlet.code.repository;

import hexlet.code.model.UrlCheck;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckRepository extends BaseRepository {
        public static void save(UrlCheck urlCheck) throws SQLException {
            String sql = "INSERT INTO url_checks (url_id, status_code,"
                    + "h1, title, description, created_at) VALUES (?, ?, ?, ?, ? ,?)";
        }

    public static List<UrlCheck> findAllCheck(Long urlId) throws SQLException {

}