package ge.tbcitacademy.swoop;

import ge.tbcitacademy.listeners.CustomListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Offers Test")
@Listeners(CustomListener.class)
public class DependsOnTests extends SwoopTestsBeforeAndAfter{
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("This test validates offers and checks whether the title contains word burger or not")
    @Story("Search validation test")
    public void searchTest() {
        search.searchBurgerInASearchBar()
                .clickToSeeEveryOffer()
                .validateEverySignleOfferTitle();
    }

    @Test(alwaysRun = true, dependsOnMethods = "searchTest")
    @Severity(SeverityLevel.MINOR)
    @Description("This test clicks on any offer and checks whether the title is displayed correctly or not")
    @Story("First Offer validation test")
    public void validateIndividualOfferNameFromSearch() {
        search.clickAnyOffer()
                .validateTitle();
    }
}
