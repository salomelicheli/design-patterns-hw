package ge.tbcitacademy.swoop;

import org.testng.annotations.Test;

public class DependsOnTests extends SwoopTestsBeforeAndAfter{
    @Test
    public void searchTest() {
        search.searchBurgerInASearchBar()
                .clickToSeeEveryOffer()
                .validateEverySignleOfferTitle();
    }

    @Test(alwaysRun = true, dependsOnMethods = "searchTest")
    public void validateIndividualOfferNameFromSearch() {
        search.clickAnyOffer()
                .validateTitle();
    }
}
