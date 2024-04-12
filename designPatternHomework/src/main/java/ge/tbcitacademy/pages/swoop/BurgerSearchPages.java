package ge.tbcitacademy.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ge.tbcitacademy.data.Constants.offerCss;
import static ge.tbcitacademy.data.Constants.specialOfferTitle;

public class BurgerSearchPages {
    public SelenideElement searchBar = $("input.reheadersearch");
    public SelenideElement buttonToSearchEveryBurger = $(byText("ყველა შეთავაზების ნახვა"));
    public ElementsCollection burgerOffers = $$(offerCss);
    public SelenideElement offerName = $(specialOfferTitle);
    public SelenideElement title = $("div.merchantTitle");

}
