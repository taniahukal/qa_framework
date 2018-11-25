package sportchek;
import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SportChekTestSuite extends BaseTest {

    @Test
    public void checkFilterItems () {
        final WebDriver webDriver = getDriver();
        final String[] expectedFilterItems = {

                "Deals & Features",
                "Men",
                "Women",
                "Kids",
                "Shoes & Footwear",
                "Gear",
                "Electronics",
                "Jerseys & Fan Wear",
                "Sneaker Launches",
                "Shop by Brand",
                "Chek advice"
        };
        webDriver.get("https://sportchek.ca/");
        final SportChekMainPage sportChekMainPage = new SportChekMainPage(webDriver);
        sportChekMainPage.expandFilterBox();
        final List<String> actualFilterItems = sportChekMainPage.getFilterItemsTextList();
        Assert.assertArrayEquals("There are incorrect items displayed!",
                expectedFilterItems, actualFilterItems.toArray());
    }

    @Test

    public void checkErrors () {
        final WebDriver webDriver = getDriver();
        final String expectedEmailError = "Please enter your email address in this format: name@example.com";
        final String expectedEmailConfirmationError = "Please enter your email address in this format: name@example.com";
        final String expectedPasswordError = "Your password must be 6-40 characters long.";
        final String expectedPasswordConfirmationError = "Your password must be 6-40 characters long.";
        webDriver.get("https://sportchek.ca/");
        final SportChekMainPage sportChekMainPage = new SportChekMainPage(webDriver);
        sportChekMainPage.expandSignInForm();
        sportChekMainPage.clickOnRegisterNowLink();
        sportChekMainPage.typeEmail("qweqw");
        sportChekMainPage.typeConfirmEmail("fsdsf");
        sportChekMainPage.typePassword("qwe");
        sportChekMainPage.typeConfirmPassword("asd");
        final String actualEmailError = sportChekMainPage.getEmailError();
        Assert.assertEquals("There are incorrect error message for Email field!",
                expectedEmailError, actualEmailError);
        final String actualEmailConfirmationError = sportChekMainPage.getEmailConfirmationError();
        Assert.assertEquals("There are incorrect error message for Confirm Email field!",
                expectedEmailConfirmationError, actualEmailConfirmationError);
        final String actualPasswordError = sportChekMainPage.getPasswordError();
        Assert.assertEquals("There are incorrect error message for Password field!",
                expectedPasswordError, actualPasswordError);
        final String actualPasswordConfirmationError = sportChekMainPage.getPasswordConfirmationError();
        Assert.assertEquals("There are incorrect error message for Confirm Password field!",
                expectedPasswordConfirmationError, actualPasswordConfirmationError);
    }
}