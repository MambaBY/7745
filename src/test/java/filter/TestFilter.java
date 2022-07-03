package filter;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CatalogProductTypePage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class TestFilter {

    @BeforeClass
    void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "C:/Users/mamby/Desktop/7745shop/Screenshot";
    }

    @Test
    @Parameters({"categoryName", "productTypeName"})
    public void verifyCatalogFilter(String categoryName, String productTypeName) {
        open("https://7745.by", MainPage.class)
                .isLogoDisplayed(true)
                .clickButtonCatalog()
                .clickCatalogCategory(categoryName)
                .clickProductType(productTypeName, CatalogProductTypePage.class)
                .isTitleDisplayed(true)
                .verifyTitleText(productTypeName)
                .clickFilterManufacturersButton();



    }

}

