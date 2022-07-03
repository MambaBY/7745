package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CatalogProductTypePage {

    private final By title = By.xpath("//*[@class = 'bread-h1 catalog-header-news-articles']");
    private final By buttonFilterManufacturers = By.xpath("//*[@class = 'catalog-filter-control__item catalog-filter-control__spoiler']");
    private final By popupManufacturers = By.cssSelector(".catalog-filter-popover__inner");
    private final By productName = By.xpath("//*[@class = 'catalog-filter__checkbox-text']");
    private final By showButton = By.xpath("//*[@class = 'btn btn-orange']");



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

}
