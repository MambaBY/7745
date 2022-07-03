package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CartPage {

    private final By title = By.xpath("//*[@class ='bread-h1 catalog-header-news-articles']");

    public CartPage isTitleDisplayed (boolean expectedValue){
        $(title).shouldBe(expectedValue ? Condition.visible : Condition.hidden);
        return page(CartPage.class);
    }
}
