package ge.tbcitacademy.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.steps.demoqawebsitesteps.BookPageSteps;
import ge.tbcitacademy.steps.demoqawebsitesteps.DemoQaSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.booksLink;

public class BookTests {
    BookPageSteps steps;
    @BeforeClass
    public void setUp(){
        open(booksLink);
        steps = new BookPageSteps();
        Configuration.timeout = 7000;
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    @AfterClass
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
    }

    @Test
    public void bookLocatorsTest() {
        steps.printingFoundBooks()
                .validatingImageNotEmpty();
    }
    @Test
    public void softAssertTest(){
        steps.checkingListSize()
                .checkingFirstRowTitle()
                .assertingAll();
    }
}
