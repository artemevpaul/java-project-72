package hexlet.code.dto;

import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class UrlsPage extends BasePage {
    private List<Url> urls;
    private Map<Long, UrlCheck> latestChecks;

    public UrlsPage(List<Url> urls, Map<Long, UrlCheck> latestChecks, String flash, String flashType) {
        this.urls = urls;
        this.latestChecks = latestChecks;
        super.setFlash(flash);
        super.setFlashType(flashType);
    }
}
