package ge.tbcitacademy.pages.telerikwebsite;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ge.tbcitacademy.data.Constants.*;
import static ge.tbcitacademy.data.Constants.indProd;

public class PricingPage {
    public SelenideElement button = $("button[class*='Btn']");
    public SelenideElement pricingsButton = $(".Pricings-button");
    public ElementsCollection bundles = $$(pricingsCSS+ " .u-tac");
    private final ElementsCollection bundleOffers = $$(".track--pricing-body tr");
    private final SelenideElement telerikReporting = bundleOffers.findBy(text(telerikreportyin));
    private final SelenideElement accessToVideos = bundleOffers.findBy(text(video));
    private final SelenideElement instances = bundleOffers.findBy(text(TElerikrep));
    public final SelenideElement el = bundleOffers.findBy(text(ISSUE_ESC));
    public ElementsCollection tdel1 =$$(".track--pricing-body tr").findBy(text(ISSUE_ESC)).$$("td");
    public ElementsCollection tdel2 = $$(".track--pricing-body tr").findBy(text(ISSUE_ESC)).$$("td");
    public ElementsCollection reporting =  telerikReporting.$$("td");
    public ElementsCollection videoAccesstd = accessToVideos.$$("td");
    public ElementsCollection instancesTd = instances.$$("td");
    public ElementsCollection coll = $$(pricingsCSS+SELECTO);
    public ElementsCollection coll1 =  $$(pricingsCSS+" .Complete div li");
    public ElementsCollection coll2 = $$("tr.Pricings-info .Ultimate div li");

    //to validate individual offers
    public SelenideElement individualProducts = $(byText(indProd));
    public SelenideElement someHeader = $("div.Box-header");
    public SelenideElement ninjaPic = $(byTitle(ninjaTitle));
    public SelenideElement somePrice = $(kTabFinder);
    public ElementsCollection someDropdowns = $$(kTabFinder +" a[class*='Dropdown']");
    public SelenideElement kendoUiPricing = $("div[id*='C713']")
            .find("[data-opti-expid='Kendo UI']").$(prices);
    public SelenideElement kendoReactPricing = $("div[id*='C713']")
            .find("[data-opti-expid='KendoReact']").$(prices);

    //for validateOrderMechanics
    public SelenideElement unitPriceEl = $(complete+" span.u-dib");
    public SelenideElement dismissButton =  $("div.row i.far");
    public SelenideElement termDropdown = $(usefulLocator2+dropDown);
    public SelenideElement termOption = $(byText("+1 year"));
    public SelenideElement updatedPrice =$(usefulLocator2+someLoc+" span span.u-db");
    public SelenideElement completeBuyButton = $(complete+" a.Btn");
    public SelenideElement annualPrice = $("span.bold");
    public SelenideElement savedMoney  = $(usefulLocator2+someLoc+" span div");
    public SelenideElement quantityDropdown = $("td[data-label*='Licenses']"+dropDown);
    public SelenideElement quantityOption =  $(byText("2"));
    public SelenideElement discount2 = $(usefulLocator+" div");
    public SelenideElement savingToValidateAccordingToDiscount = $(usefulLocator+" span");
    public SelenideElement subtotalValueEl = $("td[data-label='Subtotal'] div div.u-mt8");
    public SelenideElement questionMark = $(".container-general i.far.fa-question-circle");
    public SelenideElement discountPriceOnLabel1 = $("span.u-pr5");
    public SelenideElement discountPriceOnLabel2 = $("span.u-pr5.e2e-ms-discounts");
    public SelenideElement maintenanceSupport =  $(usefulLocator2+someLoc+" div.label");
    public SelenideElement totalPrice = $("h4.u-fr");
}
