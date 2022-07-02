package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private final By logo = By.xpath("//*[@class='header-main__logo']");
    private final By buttonCatalog = By.xpath("//*[@class = 'header-main__catalog-btn']");

    public CatalogPage clickButtonCatalog(){
        $(buttonCatalog).click();
        return page(CatalogPage.class);
    }

    public MainPage isLogoDisplayed(boolean expectedCondition){
        $(logo).shouldBe(expectedCondition ? Condition.visible : Condition.hidden);
        return page(MainPage.class);
    }
}
