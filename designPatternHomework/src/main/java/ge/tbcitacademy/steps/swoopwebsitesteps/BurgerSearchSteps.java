package ge.tbcitacademy.steps.swoopwebsitesteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbcitacademy.pages.swoop.BurgerSearchPages;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;

import static ge.tbcitacademy.data.Constants.*;

public class BurgerSearchSteps {
    BurgerSearchPages search = new BurgerSearchPages();

    @Step("Searching for burger offers in a search bar")
    @Description("This step searches for burger offers in a search bar")
    public BurgerSearchSteps searchBurgerInASearchBar(){
        search.searchBar.sendKeys(textToSearch);
        return this;
    }
    @Step("Clicking on see all offers button to see all the offers available")
    @Description("This step navigates to see all the offers")
    public BurgerSearchSteps clickToSeeEveryOffer(){
        search.buttonToSearchEveryBurger.click();
        return this;
    }
    @Step("Validating if all the offers include a word 'burger'")
    @Description("This step validates every single offer title if they include a certain word")
    public void validateEverySignleOfferTitle(){
        for(SelenideElement burger : search.burgerOffers){
            String title = burger.$(specialOfferTitle).innerText();
            String description = burger.$(offerCss+"-text").getText();
            Assert.assertTrue((title.contains(textToSearch)||description.contains(textToSearch)));
        }
    }
    private String heading ;
    @Step("Clicking on the first available offer")
    @Description("This step clicks on first offer that has appeared")
    public BurgerSearchSteps clickAnyOffer(){
        heading = search.offerName.innerText();
        search.offerName.click();
        return this;
    }
    @Step("validating that the title of the offer is displayed correctly")
    @Description("This step checks if the title of the offer is displayed correctly")
    public void validateTitle(){
        search.title.should(Condition.appear);
        Assert.assertEquals(search.title.getText(), heading);
    }

}
