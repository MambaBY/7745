package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class CatalogPage {
    private final By listCatalogCategories = By.xpath("//*[@class='catalog-nav__links']//span");
    private final By productTypePopUpElements = By.xpath("//*[@class='submenu']//li//ul//li//a");


    public CatalogPage clickCatalogCategory(String categoryName){
        SelenideElement element = $$(listCatalogCategories).find(Condition.text(String.format("%s", categoryName)));
        element.shouldBe(visible);
        element.click();

        return page(CatalogPage.class);
    }

    public <T> T clickProductType(String productTypeName, Class<T> expectedPageClass) {
        SelenideElement element = $$(productTypePopUpElements).find(Condition.text(productTypeName));
        element.shouldBe(visible);

        element.click();

        return page(expectedPageClass);
    }
}
