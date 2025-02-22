package hexlet.code.dto;

import hexlet.code.controllers.ChecksController;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UrlPage extends BasePage {
    private Url url;
    private List<UrlCheck> checksList;

    public UrlPage(Url url){
        this.url = url;
    }
    public UrlPage(Url url, List<UrlCheck> checks, String flash, String flashType){
        this.url = url;
        this.checksList = checks;
        this.setFlash(flash);
        this.setFlashType(flashType);
    }
}
