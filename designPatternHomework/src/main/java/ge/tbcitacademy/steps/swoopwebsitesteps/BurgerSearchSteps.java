package ge.tbcitacademy.steps.swoopwebsitesteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbcitacademy.pages.swoop.BurgerSearchPages;
import org.testng.Assert;

import static ge.tbcitacademy.data.Constants.*;

public class BurgerSearchSteps {
    BurgerSearchPages search = new BurgerSearchPages();

    public BurgerSearchSteps searchBurgerInASearchBar(){
        search.searchBar.sendKeys(textToSearch);
        return this;
    }
    public BurgerSearchSteps clickToSeeEveryOffer(){
        search.buttonToSearchEveryBurger.click();
        return this;
    }
    public void validateEverySignleOfferTitle(){
        for(SelenideElement burger : search.burgerOffers){
            String title = burger.$(specialOfferTitle).innerText();
            String description = burger.$(offerCss+"-text").getText();
            Assert.assertTrue((title.contains(textToSearch)||description.contains(textToSearch)));
        }
    }
    private String heading ;
    public BurgerSearchSteps clickAnyOffer(){
        heading = search.offerName.innerText();
        search.offerName.click();
        return this;
    }
    public void validateTitle(){
        search.title.should(Condition.appear);
        Assert.assertEquals(search.title.getText(), heading);
    }

}
