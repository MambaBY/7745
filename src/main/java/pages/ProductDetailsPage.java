package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductDetailsPage {

    private final By title = By.xpath("//*[@class='product__title js-prod-title']");
    private final By addToCartButton = By.xpath("//*[@class='btn btn-orange btn-buy ']");
    private final By cartButton = By.xpath("//*[@class ='svg-icon header-icon__icon--cart']");



    public ProductDetailsPage isTitleDisplayed (boolean expectedValue){
        $(title).shouldBe(expectedValue ? Condition.visible : Condition.hidden);
        return page(ProductDetailsPage.class);
    }

    public ProductDetailsPage addProductToCart (){
        $(addToCartButton).shouldBe(Condition.visible);
        $(addToCartButton).click();
        return page(ProductDetailsPage.class);
    }

    public CartPage clickCart(){
        $(cartButton).click();
        return page(CartPage.class);
    }
}
