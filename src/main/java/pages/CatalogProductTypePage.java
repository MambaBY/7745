package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CatalogProductTypePage {

    private final By title = By.xpath("//*[@class = 'bread-h1 catalog-header-news-articles']");
    private final By buttonFilterManufacturers = By.xpath("//*[@class = 'catalog-filter-control__item catalog-filter-control__spoiler']");



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

}
