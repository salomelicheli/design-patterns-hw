package ge.tbcitacademy.steps.demoqawebsitesteps;

import ge.tbcitacademy.pages.demoqa.BookPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static ge.tbcitacademy.data.Constants.patternsMessage;

public class BookPageSteps {
    BookPage book = new BookPage();
    SoftAssert sfa = new SoftAssert();

    @Step("printing the books found according to the author name...")
    @Description("this step prints found books")
    public BookPageSteps printingFoundBooks(){
        book.bookRows.forEach(book -> System.out.println(book.getText()));
        return this;
    }
    @Step("validating that each books image is not empty on the website...")
    @Description("This step validates that Image is Not Empty")
    public void validatingImageNotEmpty(){
        String att = book.bookImages.getAttribute("src");
        Assert.assertNotNull(att);
    }

    @Step("Checking if the list size is same as the expected size")
    @Description("This step checks list size")
    public BookPageSteps checkingListSize(){
        sfa.assertEquals(book.JsBooks.size(),10);
        return this;
    }
    @Step("Checking if the first book title is the same as a given message...")
    @Description("first row title check")
    public BookPageSteps checkingFirstRowTitle(){
        sfa.assertEquals(book.firstElement.getText(), patternsMessage);
        return this;
    }
    public void assertingAll(){
        sfa.assertAll();
    }
}
