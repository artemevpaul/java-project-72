package hexlet.code.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class Url {
    private long id;
    private String name;
    private LocalDateTime createdAt;
    private UrlCheck lastCheck;

    public Url(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }
}
