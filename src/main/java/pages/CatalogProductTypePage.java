package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CatalogProductTypePage {

    private final By logo = By.xpath("//*[@class='header-main__logo']");




    public CatalogProductTypePage isLogoDisplayedCatalog(boolean expectedCondition){
        $(logo).shouldBe(expectedCondition ? Condition.visible : Condition.hidden);
        return page(CatalogProductTypePage.class);
    }
}
