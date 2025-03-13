package hexlet.code;

import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.CheckRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AppTest {
    public static String baseUrl;
    static MockWebServer mockServer;
    private Javalin app;

    public static final String TEST_PAGE = "TestPage.html";

    public static String getFile() throws IOException {
        var path = Paths.get("src", "test", "resources", "TestPage.html").toAbsolutePath().normalize();
        return Files.readString(path);
    }

    @BeforeAll
    static void serverSetUp() throws Exception {
        mockServer = new MockWebServer();
        MockResponse mockResponse = new MockResponse()
                .setBody(getFile())
                .setResponseCode(200);
        mockServer.enqueue(mockResponse);
        mockServer.start();
        baseUrl = mockServer.url("/").toString();
    }

    @AfterAll
    public static void afterAll() throws IOException {
        mockServer.shutdown();
    }

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
    }

    @Test
    public void testMainPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Анализатор страниц");
        });
    }

    @Test
    public void testUrlsPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls");
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    public void testCreateUrl() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=https://www.youtube.com";
            var response = client.post("/urls", requestBody);
            assertThat(UrlRepository.findName("https://www.youtube.com")).isPresent();
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://www.youtube.com");
        });
    }

    @Test
    public void testUrlPage() throws SQLException {
        var url = new Url("https://www.youtube.com");
        UrlRepository.save(url);
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls/" + url.getId());
            assertThat(UrlRepository.findName("https://www.youtube.com")).isPresent();
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://www.youtube.com");
        });
    }

    @Test
    void testCheckUrl() throws SQLException {
        var url = new Url(baseUrl);
        UrlRepository.save(url);
        var savedUrl = UrlRepository.findName(url.getName()).orElseThrow();

        JavalinTest.test(app, (server, client) -> {
            var response = client.post(NamedRoutes.urlChecksPath(savedUrl.getId()));
            List<UrlCheck> checks = CheckRepository.findAllChecks(savedUrl.getId());
            var check = checks.get(0);
            assertThat(response.code()).isEqualTo(200);
            assertThat(check.getStatusCode()).isEqualTo(200);
            assertThat(check.getH1()).isEqualTo("Welcome");
            assertThat(check.getDescription()).isEqualTo("Test description");
        });
    }
}
