package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;

import java.nio.charset.CoderMalfunctionError;

import static com.codeborne.selenide.Selenide.*;

public class CatalogProductTypePage {

    private final By title = By.xpath("//*[@class = 'bread-h1 catalog-header-news-articles']");
    private final By buttonFilterManufacturers = By.xpath("//*[@class = 'catalog-filter-control__item catalog-filter-control__spoiler']");
    private final By popupManufacturers = By.cssSelector(".catalog-filter-popover__inner");
    private final By productName = By.xpath("//*[@class = 'catalog-filter__checkbox-text']");
    private final By showButton = By.xpath("//*[@class ='catalog-sbf-top catalog-sbf-btnset']//button[1]");
    //private final By appliedProduct = By.xpath("//*[@class ='catalog-filter__checkbox-item']//span[@class='i-checkbox']");
    private final By filteredProducts = By.xpath("//*[@class='catalog-item__wrapper']");
    private final By productTitles = By.xpath("//*[@class ='catalog-item__row-block-info catalog-item__row-block-info--clmn catalog-item__row-block-info--h-title-stars']/div[1]");



 //метод проверяет прогрузилась ли страница, а конкретно оотобразился ли Title
    public CatalogProductTypePage isTitleDisplayed(boolean expectedCondition){
        $(title).shouldBe(expectedCondition ? Condition.visible : Condition.hidden);
        return page(CatalogProductTypePage.class);
    }

    //метод проверяет текс Title
    public CatalogProductTypePage verifyTitleText(String expectedProductType){
        $(title).shouldHave(Condition.text(expectedProductType));
        return page(CatalogProductTypePage.class);
    }


    //метод кликает на кнопку производитель
    public CatalogProductTypePage clickFilterManufacturersButton(){
        $(buttonFilterManufacturers).click();
        return page(CatalogProductTypePage.class);
    }

    public CatalogProductTypePage clickManufacturerInDropdown(String name){
        $(popupManufacturers).shouldBe(Condition.visible);

        SelenideElement element = $$(productName).find(Condition.text(name));
        element.shouldBe(Condition.visible);
        element.click();
        return page(CatalogProductTypePage.class);
    }

    // проверить ShowButton
    public CatalogProductTypePage isShowButtonDisplayed (boolean expectedCondition){
        $(showButton).shouldBe(expectedCondition ? Condition.visible : Condition.hidden);
        return page(CatalogProductTypePage.class);
    }

    public CatalogProductTypePage clickShowButton(){
        $(showButton).click();
        return page(CatalogProductTypePage.class);

    }

//    public CatalogProductTypePage isProductSelected (String name){
//        SelenideElement element = $(By.xpath(String.format("//*[@class ='catalog-filter__checkbox-item' and contains('%s')]", name + "//span[@class='i-checkbox']")));
//
//
//
//        //$(appliedProduct).find(Condition.text(name));
//        element.shouldBe(Condition.checked);
//        return page(CatalogProductTypePage.class);
//    }

    public CatalogProductTypePage verifyFelteredProductsAmmount (int expectedValue){
        $$(filteredProducts).shouldBe(CollectionCondition.sizeLessThanOrEqual(expectedValue));
        return page(CatalogProductTypePage.class);
    }

    public CatalogProductTypePage verifyFilteredProductContainsText(String expectedValue){
        for (SelenideElement element : $$(productTitles)){
            element.shouldHave(Condition.text(expectedValue));
        }
        return page(CatalogProductTypePage.class);
    }

    public ProductDetailsPage clickOnProduct (int productNumber){
       SelenideElement element = $(By.xpath(String.format("//*[@class = 'catalog-item catalog-item--shadow-hover js-product-control-root                     popup-class-trigger'][%s]/div/div", productNumber)));

       element.shouldBe(Condition.visible);
       element.click();
       return page(ProductDetailsPage.class);
    }



}
