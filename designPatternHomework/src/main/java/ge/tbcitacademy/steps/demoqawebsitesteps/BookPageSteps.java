package ge.tbcitacademy.steps.demoqawebsitesteps;

import ge.tbcitacademy.pages.demoqa.BookPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static ge.tbcitacademy.data.Constants.patternsMessage;

public class BookPageSteps {
    BookPage book = new BookPage();
    SoftAssert sfa = new SoftAssert();

    public BookPageSteps printingFoundBooks(){
        book.bookRows.forEach(book -> System.out.println(book.getText()));
        return this;
    }
    public void validatingImageNotEmpty(){
        String att = book.bookImages.getAttribute("src");
        Assert.assertNotNull(att);
    }

    public BookPageSteps checkingListSize(){
        sfa.assertEquals(book.JsBooks.size(),10);
        return this;
    }
    public BookPageSteps checkingFirstRowTitle(){
        sfa.assertEquals(book.firstElement.getText(), patternsMessage);
        return this;
    }
    public void assertingAll(){
        sfa.assertAll();
    }
}
