package ge.tbcitacademy.steps.telerikwebsitesteps;

import com.codeborne.selenide.Condition;
import ge.tbcitacademy.helper.HelperMethods;
import ge.tbcitacademy.pages.telerikwebsite.DemosPage;
import ge.tbcitacademy.pages.telerikwebsite.PricingPage;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ge.tbcitacademy.data.Constants.*;

public class PricingPageSteps {
    DemosPage demosPage = new DemosPage();
    PricingPage pricingPage =  new PricingPage();
    int devCraftUiInd = pricingPage.bundles.texts().indexOf(DEVCRAFT_UI)+1;
    int devCraftComplete = pricingPage.bundles.texts().indexOf(DEVCRAFT_UI)+2;
    int devCraftUltimateInd = pricingPage.bundles.texts().indexOf(DEVCRAFT_ULTIMATE)+1;
    public PricingPageSteps goToPricingSection(){
        demosPage.pricingPageLink.click();
        return this;
    }
    public PricingPageSteps scrollToPricingButton(){
        pricingPage.pricingsButton.scrollTo();
        return this;
    }
    public PricingPageSteps clickingButtonToSeeMore(){
        pricingPage.button.click();
        return this;
    }
    public PricingPageSteps validatingEscalationInUltimatePackage(){
        devCraftUiInd = pricingPage.bundles.texts().indexOf(DEVCRAFT_UI)+1;
        devCraftComplete = pricingPage.bundles.texts().indexOf(DEVCRAFT_UI)+2;
        devCraftUltimateInd = pricingPage.bundles.texts().indexOf(DEVCRAFT_ULTIMATE)+1;
        pricingPage.tdel1.get(devCraftUltimateInd).shouldNotHave(exactText(""));
        pricingPage.tdel1.get(devCraftComplete).shouldHave(exactText(""));
        pricingPage.tdel1.get(devCraftUiInd).shouldHave(exactText(""));
        return this;
    }
    public PricingPageSteps validatingTestStudio(){
        pricingPage.tdel2.get(devCraftUltimateInd).shouldNotHave(exactText(""));
        pricingPage.tdel2.get(devCraftComplete).shouldHave(exactText(""));
        pricingPage.tdel2.get(devCraftUiInd).shouldHave(exactText(""));
        return this;
    }
    public PricingPageSteps validateTelerikReportingInUltimateAndComplete(){
        pricingPage.reporting.get(devCraftUltimateInd).shouldNotHave(exactText(""));
        pricingPage.reporting.get(devCraftComplete).shouldNotHave(exactText(""));
        pricingPage.reporting.get(devCraftUiInd).shouldHave(exactText(""));
        return this;
    }
    public PricingPageSteps onDemandVideosInAllOffers(){
        pricingPage.videoAccesstd.forEach(tdel -> tdel.shouldNotHave(exactText("")));
        return this;
    }
    public PricingPageSteps validateInstaceText(){
        pricingPage.instancesTd.get(devCraftUltimateInd).shouldHave(text(UserInstance));
        return this;
    }
    public PricingPageSteps mockingSolutionInDevUI(){
        pricingPage.coll.forEach(ulElement -> ulElement.shouldNotHave(text(rapidTesting)));
        return this;
    }
    public PricingPageSteps endToEndInUltimate(){
        pricingPage.coll1.forEach(liElement-> liElement.shouldNotHave(text(END_TO_END)));
        pricingPage.coll.forEach(ulElement -> ulElement.shouldNotHave(text(END_TO_END)));
        Assert.assertTrue(pricingPage.coll2.texts().contains(END_TO_END));
        return this;
    }
    //validate individual offers
    public PricingPageSteps  clickOnIndividualProducts(){
        pricingPage.individualProducts.click();
        return this;
    }
    public PricingPageSteps hoverOnAHeader(){
        pricingPage.someHeader.hover();
        return this;
    }
    public PricingPageSteps validateApparitionOfANinja(){
        pricingPage.ninjaPic.should(Condition.appear);
        return this;
    }
    public PricingPageSteps scrollToPrice(){
        pricingPage.somePrice.scrollTo();
        return this;
    }
    public PricingPageSteps validatingDropdowns(){
        pricingPage.someDropdowns.forEach(dropdown -> dropdown.shouldHave(text(priorSupportText)));
        return this;
    }
    public PricingPageSteps validateKendoUIPrice(){
        pricingPage.kendoUiPricing.shouldHave(text(price1));
        return this;
    }
    public void validateKendoReactPricing(){
        pricingPage.kendoReactPricing.shouldHave(text(price2));
    }

    //----------------------------------------------//
    private double doubleUnitPrice;
    public PricingPageSteps clickBuyingButtonOnComplete(){
        String unitPrice = pricingPage.unitPriceEl.getText();
        String sanitizedInput = unitPrice.replaceAll("[,\\s]+", "");
        doubleUnitPrice = Double.parseDouble(sanitizedInput);
        pricingPage.completeBuyButton.click();
        return this;
    }
    public PricingPageSteps clickLoginDismissButton(){
        pricingPage.dismissButton.shouldBe(Condition.visible).click();
        return this;
    }
    private double annualPrice;
    public PricingPageSteps getAnnualPriceAndChangeTerm(){
        annualPrice = HelperMethods.extractPrice(pricingPage.annualPrice, 1);
        pricingPage.termDropdown.click();
        return this;
    }
    public PricingPageSteps changingTerm(){
        pricingPage.termOption.click();
        return this;
    }
    private double newPriceToDouble;
    private double discount;
    public PricingPageSteps validatePriceAfterTermChange(){
        pricingPage.updatedPrice.shouldHave(Condition.text("8"));
        newPriceToDouble = HelperMethods.extractPrice(pricingPage.updatedPrice, 1);
        discount =  HelperMethods.extractPrice(pricingPage.savedMoney, 6);
        Assert.assertEquals(annualPrice-discount, newPriceToDouble);
        return this;
    }
    private double anotherDiscount;
    private double savingAccordingToDiscount;
    public PricingPageSteps clickOnDropDown(){
        pricingPage.quantityDropdown.click();
        return this;
    }
    public PricingPageSteps chooseQuantityOption(){
        pricingPage.quantityOption.click();
        return this;
    }
    public PricingPageSteps validatePriceAfterQuantityChange(){
       anotherDiscount=  HelperMethods.extractPrice(pricingPage.discount2, 6);
       savingAccordingToDiscount = HelperMethods
               .modifyAndExtractPrice(pricingPage.savingToValidateAccordingToDiscount, 1);
        Assert.assertEquals(doubleUnitPrice-anotherDiscount,savingAccordingToDiscount );
        return this;
    }

    private double trmPrice;
    private double subTotal;
    public PricingPageSteps validateSubtotalValue(){
        trmPrice = HelperMethods.modifyAndExtractPrice(pricingPage.updatedPrice, 1);
        subTotal = HelperMethods.modifyAndExtractPrice(pricingPage.subtotalValueEl, 1);
        Assert.assertEquals(savingAccordingToDiscount*2+trmPrice, subTotal);
        return this;
    }
    public PricingPageSteps hoverOnQuestionMark(){
        pricingPage.questionMark.hover();
        return this;
    }
    private double licensesDiscountPrice;
    private double supportDiscountToCompare;
    public PricingPageSteps validateTotalDiscountsOnALabel(){
        licensesDiscountPrice = HelperMethods.modifyAndExtractPrice(pricingPage.discountPriceOnLabel1
                .shouldBe(Condition.visible), 3);
        Assert.assertEquals(anotherDiscount*2, licensesDiscountPrice);
        return this;
    }
    private double maintenance;
    public PricingPageSteps validateSupportDiscountOnLabel(){
        supportDiscountToCompare = HelperMethods.modifyAndExtractPrice(pricingPage.discountPriceOnLabel2
                .shouldBe(Condition.visible), 3);
        maintenance = HelperMethods.modifyAndExtractPrice(pricingPage.maintenanceSupport, 6);
        Assert.assertEquals(supportDiscountToCompare,maintenance);
        return this;
    }
    private double totalPRice;
    public void validateTotalValue(){
        totalPRice = HelperMethods.modifyAndExtractPrice(pricingPage.totalPrice, 4);
        Assert.assertEquals(subTotal,totalPRice);
    }
}
