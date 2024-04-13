package ge.tbcitacademy.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.listeners.CustomListener;
import ge.tbcitacademy.steps.demoqawebsitesteps.BookPageSteps;
import ge.tbcitacademy.steps.demoqawebsitesteps.DemoQaSteps;
import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.booksLink;

@Epic("Selenide Homework")
@Feature("Book tests")
@Listeners(CustomListener.class)
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
    @Severity(SeverityLevel.TRIVIAL)
    @Description("This test filters the book offers according to author and a title and validates the images")
    @Story("Test to filter books and validate images")
    public void bookLocatorsTest() {
        steps.printingFoundBooks()
                .validatingImageNotEmpty();
    }
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("This test filters the book offers according to the author and a title and checks the collection size")
    @Story("Test to validate collection size")
    public void softAssertTest(){
        steps.checkingListSize()
                .checkingFirstRowTitle()
                .assertingAll();
    }
}
