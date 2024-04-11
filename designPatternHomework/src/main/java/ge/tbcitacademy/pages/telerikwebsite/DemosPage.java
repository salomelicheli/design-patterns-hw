package ge.tbcitacademy.pages.telerikwebsite;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ge.tbcitacademy.data.Constants.cookies;
import static ge.tbcitacademy.data.Constants.loccC;

public class DemosPage {
    public SelenideElement pricingPageLink = $(byText("Pricing"));
    public SelenideElement cookieButton = $(byText(cookies));
    public SelenideElement webSection =  $(By.linkText("Web"));
    public SelenideElement webLabel = $("h2#web");
    public ElementsCollection hoveringImg = $$(loccC);
    public SelenideElement stickyElement = $(".fixed-dummy");
    public ElementsCollection collect = $(loccC).$(byTitle("Kendo Ui")).sibling(0).$$(By.tagName("a"));
    public SelenideElement desktopSection =  $(By.linkText("Desktop"));
    public ElementsCollection filteredCollect = $$("div[id*='C337'] a img")
            .filterBy(Condition.attribute("title", "Get It from Microsoft"));
    public SelenideElement desktopLabel = $("h2#desktop");
    public SelenideElement mobileSection = $(By.linkText("Mobile"));
    public SelenideElement mobileLabel = $("h2#mobile");
    public ElementsCollection xamarinElements = $("div[id*='C340_Col01']").findAll("a img");
}
