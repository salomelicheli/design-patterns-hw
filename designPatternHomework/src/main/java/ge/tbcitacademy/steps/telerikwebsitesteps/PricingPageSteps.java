package ge.tbcitacademy.steps.telerikwebsitesteps;

import com.codeborne.selenide.Condition;
import ge.tbcitacademy.helper.HelperMethods;
import ge.tbcitacademy.pages.telerikwebsite.DemosPage;
import ge.tbcitacademy.pages.telerikwebsite.PricingPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
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
    @Step("Going to pricing sections")
    @Description("This step takes us to the pricing page")
    public PricingPageSteps goToPricingSection(){
        demosPage.pricingPageLink.click();
        return this;
    }
    @Step("Scrolling to pricing button so its into view")
    @Description("This step scrolls to pricing button so the click is not intercepted in any way")
    public PricingPageSteps scrollToPricingButton(){
        pricingPage.pricingsButton.scrollTo();
        return this;
    }
    @Step("clicking on a button to see more")
    @Description("This step clicks on the see more button so all the offers are visible")
    public PricingPageSteps clickingButtonToSeeMore(){
        pricingPage.button.click();
        return this;
    }
    @Step("Validating that the issue escalation is only included in Ultimate package")
    @Description("This step validates if issue escalation is available only in ultimate package")
    public PricingPageSteps validatingEscalationInUltimatePackage(){
        devCraftUiInd = pricingPage.bundles.texts().indexOf(DEVCRAFT_UI)+1;
        devCraftComplete = pricingPage.bundles.texts().indexOf(DEVCRAFT_UI)+2;
        devCraftUltimateInd = pricingPage.bundles.texts().indexOf(DEVCRAFT_ULTIMATE)+1;
        pricingPage.tdel1.get(devCraftUltimateInd).shouldNotHave(exactText(""));
        pricingPage.tdel1.get(devCraftComplete).shouldHave(exactText(""));
        pricingPage.tdel1.get(devCraftUiInd).shouldHave(exactText(""));
        return this;
    }
    @Step("Validation")
    @Description("This validates if Test Studio is only available in ultimate bundle")
    public PricingPageSteps validatingTestStudio(){
        pricingPage.tdel2.get(devCraftUltimateInd).shouldNotHave(exactText(""));
        pricingPage.tdel2.get(devCraftComplete).shouldHave(exactText(""));
        pricingPage.tdel2.get(devCraftUiInd).shouldHave(exactText(""));
        return this;
    }
    @Step("Validating that Telerik report is only in complete and ultimate packages")
    @Description("This validates if Telerik reporting is only available in ultimate bundle")
    public PricingPageSteps validateTelerikReportingInUltimateAndComplete(){
        pricingPage.reporting.get(devCraftUltimateInd).shouldNotHave(exactText(""));
        pricingPage.reporting.get(devCraftComplete).shouldNotHave(exactText(""));
        pricingPage.reporting.get(devCraftUiInd).shouldHave(exactText(""));
        return this;
    }
    @Step("Validating that onDemand videos is only in all of the offers")
    @Description("This step validates if on demand videos is available in all the bundle")
    public PricingPageSteps onDemandVideosInAllOffers(){
        pricingPage.videoAccesstd.forEach(tdel -> tdel.shouldNotHave(exactText("")));
        return this;
    }
    @Step("Validating instance text")
    @Description("This step validates the instance text")
    public PricingPageSteps validateInstaceText(){
        pricingPage.instancesTd.get(devCraftUltimateInd).shouldHave(text(UserInstance));
        return this;
    }
    @Step("Validating that mocking solution in dev ui is in every offer")
    @Description("This step validates if mocking solution in Dev UI is only available in ultimate bundle")
    public PricingPageSteps mockingSolutionInDevUI(){
        pricingPage.coll.forEach(ulElement -> ulElement.shouldNotHave(text(rapidTesting)));
        return this;
    }
    @Step("Validating endtoend Ultimate")
    @Description("This step validates if End-to-end solution is only available in ultimate bundle")
    public PricingPageSteps endToEndInUltimate(){
        pricingPage.coll1.forEach(liElement-> liElement.shouldNotHave(text(END_TO_END)));
        pricingPage.coll.forEach(ulElement -> ulElement.shouldNotHave(text(END_TO_END)));
        Assert.assertTrue(pricingPage.coll2.texts().contains(END_TO_END));
        return this;
    }
    //validate individual offers
    @Step("Going to individual offers section")
    @Description("This step takes us to the individual products section")
    public PricingPageSteps  clickOnIndividualProducts(){
        pricingPage.individualProducts.click();
        return this;
    }
    @Step("Hovering on a header...")
    @Description("This step hovers on a header to see if a ninja picture appears")
    public PricingPageSteps hoverOnAHeader(){
        pricingPage.someHeader.hover();
        return this;
    }
    @Step("Validating that a ninja picture has appeared on hover")
    @Description("this step validates the apparition of a ninja")
    public PricingPageSteps validateApparitionOfANinja(){
        pricingPage.ninjaPic.should(Condition.appear);
        return this;
    }
    @Step("Scrolling to price...")
    @Description("This step scrolls to the prics so its into view")
    public PricingPageSteps scrollToPrice(){
        pricingPage.somePrice.scrollTo();
        return this;
    }
    @Step("Validating the dropdowns...")
    @Description("This step validates if dropdowns on a pricing page each contain some priority support text")
    public PricingPageSteps validatingDropdowns(){
        pricingPage.someDropdowns.forEach(dropdown -> dropdown.shouldHave(text(priorSupportText)));
        return this;
    }
    @Step("Validating Kendo UI price...")
    @Description("This step validates if the kendo UI price is as expected")
    public PricingPageSteps validateKendoUIPrice(){
        pricingPage.kendoUiPricing.shouldHave(text(price1));
        return this;
    }
    @Step("Validating Kendo React price...")
    @Description("This step validates if Kendo React price is as expected")
    public void validateKendoReactPricing(){
        pricingPage.kendoReactPricing.shouldHave(text(price2));
    }

    //----------------------------------------------//
    private double doubleUnitPrice;
    @Step("Click on buying on complete...")
    @Description("This step clicks on complete button")
    public PricingPageSteps clickBuyingButtonOnComplete(){
        String unitPrice = pricingPage.unitPriceEl.getText();
        String sanitizedInput = unitPrice.replaceAll("[,\\s]+", "");
        doubleUnitPrice = Double.parseDouble(sanitizedInput);
        pricingPage.completeBuyButton.click();
        return this;
    }
    @Step("Click on dismissing a login button")
    @Description("This step clicks on a login dismiss button")
    public PricingPageSteps clickLoginDismissButton(){
        pricingPage.dismissButton.shouldBe(Condition.visible).click();
        return this;
    }
    private double annualPrice;
    @Step("Getting annual price to check")
    @Description("This step gets annual price and after clicks on a dropdown to see the term options")
    public PricingPageSteps getAnnualPriceAndChangeTerm(){
        annualPrice = HelperMethods.extractPrice(pricingPage.annualPrice, 1);
        pricingPage.termDropdown.click();
        return this;
    }
    @Step("Changing the term...")
    @Description("This step changes the term to see the price change")
    public PricingPageSteps changingTerm(){
        pricingPage.termOption.click();
        return this;
    }
    private double newPriceToDouble;
    private double discount;
    @Step("Validating price after therm change")
    @Description("This step validates price after the term change")
    public PricingPageSteps validatePriceAfterTermChange(){
        pricingPage.updatedPrice.shouldHave(Condition.text("8"));
        newPriceToDouble = HelperMethods.extractPrice(pricingPage.updatedPrice, 1);
        discount =  HelperMethods.extractPrice(pricingPage.savedMoney, 6);
        Assert.assertEquals(annualPrice-discount, newPriceToDouble);
        return this;
    }
    private double anotherDiscount;
    private double savingAccordingToDiscount;
    @Step("Clicking on dropdown...")
    @Description("This step clicks on a dropdown to change the quantity of bundles")
    public PricingPageSteps clickOnDropDown(){
        pricingPage.quantityDropdown.click();
        return this;
    }
    @Step("Choosing quantity option")
    @Description("This step chooses the quantity option")
    public PricingPageSteps chooseQuantityOption(){
        pricingPage.quantityOption.click();
        return this;
    }
    @Step("Validating price...")
    @Description("This step validates the price after changing the quantity")
    public PricingPageSteps validatePriceAfterQuantityChange(){
       anotherDiscount=  HelperMethods.extractPrice(pricingPage.discount2, 6);
       savingAccordingToDiscount = HelperMethods
               .modifyAndExtractPrice(pricingPage.savingToValidateAccordingToDiscount, 1);
        Assert.assertEquals(doubleUnitPrice-anotherDiscount,savingAccordingToDiscount );
        return this;
    }

    private double trmPrice;
    private double subTotal;
    @Step("Validating subtotal value...")
    @Description("This step validates the subtotal value")
    public PricingPageSteps validateSubtotalValue(){
        trmPrice = HelperMethods.modifyAndExtractPrice(pricingPage.updatedPrice, 1);
        subTotal = HelperMethods.modifyAndExtractPrice(pricingPage.subtotalValueEl, 1);
        Assert.assertEquals(savingAccordingToDiscount*2+trmPrice, subTotal);
        return this;
    }
    @Step("Hovering on a question mark...")
    @Description("This step hovers on a question mark to see the discounts")
    public PricingPageSteps hoverOnQuestionMark(){
        pricingPage.questionMark.hover();
        return this;
    }
    private double licensesDiscountPrice;
    private double supportDiscountToCompare;
    @Step("Validating the discounts...")
    @Description("This step validates discounts that have appeared on a label after hovering on a question mark")
    public PricingPageSteps validateTotalDiscountsOnALabel(){
        licensesDiscountPrice = HelperMethods.modifyAndExtractPrice(pricingPage.discountPriceOnLabel1
                .shouldBe(Condition.visible), 3);
        Assert.assertEquals(anotherDiscount*2, licensesDiscountPrice);
        return this;
    }
    private double maintenance;
    @Step("Validating the support discount...")
    @Description("this step Validates the support discount that has appeared on a label after hovering on a question mark")
    public PricingPageSteps validateSupportDiscountOnLabel(){
        supportDiscountToCompare = HelperMethods.modifyAndExtractPrice(pricingPage.discountPriceOnLabel2
                .shouldBe(Condition.visible), 3);
        maintenance = HelperMethods.modifyAndExtractPrice(pricingPage.maintenanceSupport, 6);
        Assert.assertEquals(supportDiscountToCompare,maintenance);
        return this;
    }
    private double totalPRice;
    @Step("Validating the total value displayed")
    @Description("This step validates the total value after making the changes")
    public void validateTotalValue(){
        totalPRice = HelperMethods.modifyAndExtractPrice(pricingPage.totalPrice, 4);
        Assert.assertEquals(subTotal,totalPRice);
    }
}
