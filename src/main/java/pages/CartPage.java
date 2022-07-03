package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private final By title = By.xpath("//*[@class ='bread-h1 catalog-header-news-articles']");
    private final By itemsInCart = By.xpath("//*[@class = 'product-section__item product-item']");
    private final By totalSumValue = By.xpath("//*[@class = 'sidebar-block sidebar-block--big']");

    public CartPage isTitleDisplayed (boolean expectedValue){
        $(title).shouldBe(expectedValue ? Condition.visible : Condition.hidden);
        return page(CartPage.class);
    }

    public CartPage isProductDysplayed(boolean expectedValue){
        $(itemsInCart).shouldBe(expectedValue ? Condition.visible : Condition.hidden);
        return page(CartPage.class);
    }

    public CartPage isTotalSumValueDisplayed (boolean expectedValue){
        $(totalSumValue).shouldBe(expectedValue ? Condition.visible : Condition.hidden);
        return page(CartPage.class);
    }

    public CartPage verifyProductsAmmountInCart (){
        $$(itemsInCart).shouldBe(CollectionCondition.sizeGreaterThan(0));
        return page(CartPage.class);
    }
}
