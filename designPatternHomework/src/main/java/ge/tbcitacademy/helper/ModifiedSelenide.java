package ge.tbcitacademy.helper;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.selenide.AllureSelenide;

public class ModifiedSelenide extends AllureSelenide {
    private boolean saveScreens;
    @Override
    public ModifiedSelenide screenshots(boolean saveScreens) {
        if (WebDriverRunner.hasWebDriverStarted()){
            this.saveScreens = saveScreens;
        }
        return this;
    }
}
