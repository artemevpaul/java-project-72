package hexlet.code.dto;

import hexlet.code.controllers.ChecksController;
import hexlet.code.model.Url;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UrlsPage extends BasePage {
    private List<Url> urls;

    public UrlsPage(List<Url> urls, String flash, String flashType){
        this.urls = urls;
        super.setFlash(flash);
        super.setFlashType(flashType);
    }
}