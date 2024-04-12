package ge.tbcitacademy.pages.demoqa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ge.tbcitacademy.data.Constants.jsLocator;
import static org.openqa.selenium.By.xpath;

public class BookPage {
  public SelenideElement book = $(".rt-tr-group");
  public ElementsCollection bookRows =$$(".rt-tr-group").filterBy(text("O'Reilly Media"))
           .filterBy(text("JavaScript"));
  public ElementsCollection JsBooks = $(".books-wrapper").find(".rt-tbody").findAll(".rt-tr-group")
          .filterBy(text("O'Reilly Media"))
          .filterBy(text("JavaScript"));
  public SelenideElement bookImages = $(".books-wrapper").$(".rt-tbody").$(By.tagName("img"));
  public SelenideElement firstElement = $(xpath(jsLocator));


}
