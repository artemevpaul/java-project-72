package hexlet.code;

import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class App {
    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }

    public static Javalin getApp() throws IOException {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");
        return Javalin.create().get("/", ctx -> ctx
                .result("Hello World"));
    }

    public static void main(String[] args) throws IOException {
        Javalin app = getApp();
        app.start(getPort());
    }
}
