package FlyComTest;

import common.BaseTest;
import fly.FlyComMainPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlyComTestSuite extends BaseTest {

    @Test

    public void checkDepartDate () {
        final WebDriver webDriver = getDriver();
        final String expectedText = "12 January 2019";
        webDriver.get("https://www.fly.com/");
        final FlyComMainPage flyComMainPage = new FlyComMainPage(webDriver);
        flyComMainPage.typeTextFrom("Zhuliany Intl(IEV)");
        flyComMainPage.typeTextTo("Vitoria, Spain - Vitoria");
        flyComMainPage.selectRadioButton();
        flyComMainPage.clickOnDepartDate();
        flyComMainPage.setMonthAndYear("December 2019");;
        flyComMainPage.setDay("29");
        //flyComMainPage.clickOnSearchButton();
    }

}
