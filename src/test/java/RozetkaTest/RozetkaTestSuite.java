package RozetkaTest;

import common.BaseTest;
import fly.FlyComMainPage;
import google.GoogleMainPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import rozetka.ProductDetailsPage;
import rozetka.RozetkaMainPage;
import rozetka.SearchResultPage;
import rozetka.WishlistPage;

public class RozetkaTestSuite extends BaseTest {

    @Test
    public void  checkWishlistOnRozetka () {

        final WebDriver webDriver = getDriver();
        final String expectedItemText = "Apple iPhone Xs Max 512GB Dual Sim Space Gray (MT772)";
        webDriver.get("https://rozetka.com.ua/ua/");

        final RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(webDriver);
        rozetkaMainPage.typeTextIntoSearchInput("iphone xs max");
        rozetkaMainPage.clickSearchButton();

        final SearchResultPage searchResultPage = new SearchResultPage(webDriver);
        searchResultPage.clickOnSearchResult();

        final ProductDetailsPage productDetailsPage = new ProductDetailsPage(webDriver);
        productDetailsPage.clickOnHeartButton();
        productDetailsPage.typeTextToLoginField("hggfg@gmail.com");
        productDetailsPage.clickOnSaveButton();
        productDetailsPage.typeTextToFioField("hhjfhh qwerqwrwer");
        productDetailsPage.clickOnSubmitButton();
        productDetailsPage.clickOnWhishlistButton();

        final WishlistPage wishlistPage = new WishlistPage(webDriver);

        final String actualItemsText = wishlistPage.getItemText();
        Assert.assertEquals("There are no items in wishlist!", expectedItemText, actualItemsText);
    }

}
