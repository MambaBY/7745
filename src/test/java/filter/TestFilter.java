package filter;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CatalogProductTypePage;
import pages.MainPage;

import java.sql.Date;

import static com.codeborne.selenide.Selenide.*;

public class TestFilter {

    @BeforeClass
    void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "C:/Users/mamby/Desktop/7745shop/Screenshot";
        Configuration.baseUrl = "https://7745.by";
    }

    @Test
    @Parameters({"categoryName", "productTypeName", "manufacturerName", "expectedAmount", "productNumber"})
    public void verifyCatalogFilter(String categoryName, String productTypeName, String manufacturerName, int expectedAmount, int productNumber) {
        open("/", MainPage.class)
                .isLogoDisplayed(true)
                .clickButtonCatalog()
                .clickCatalogCategory(categoryName)
                .clickProductType(productTypeName, CatalogProductTypePage.class)
                .isTitleDisplayed(true)
                .verifyTitleText(productTypeName)
                .clickFilterManufacturersButton()
                .clickManufacturerInDropdown(manufacturerName)
                .isShowButtonDisplayed(true)
                .clickShowButton()
                .isTitleDisplayed(true)
                .verifyFelteredProductsAmmount(expectedAmount)
                .verifyFilteredProductContainsText(manufacturerName)
                .clickOnProduct(productNumber)
                .isTitleDisplayed(true)
                .addProductToCart()
                .clickCart()
                .isTitleDisplayed(true)
                .isProductDysplayed(true)
                .isTotalSumValueDisplayed(true)
                .verifyProductsAmmountInCart();

        screenshot("Test result for " + manufacturerName);

    }

    @AfterMethod
    void closeDriver() {
        closeWebDriver();
    }


}

