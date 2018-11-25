package rozetka;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaMainPage {

    @FindBy (xpath = "//input[@class='rz-header-search-input-text passive']")
    WebElement searchInput;

    @FindBy (xpath = "//button[@class='btn-link-i js-rz-search-button']")
    WebElement searchButton;

        private WebDriver webDriver;

        private WebDriverWait webDriverWait;

        private static final Long ELEMENT_WAIT_TIME_OUT = 30L;

        public RozetkaMainPage (final WebDriver webDriver) {
            this.webDriver = webDriver;
            webDriverWait = new WebDriverWait(webDriver, ELEMENT_WAIT_TIME_OUT );
            PageFactory.initElements(webDriver, this);
        }

        public void typeTextIntoSearchInput (final String text) {
            searchInput.sendKeys(text, Keys.ENTER);
        }

        public SearchResultPage clickSearchButton () {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
            return new SearchResultPage (webDriver);
        }




}
