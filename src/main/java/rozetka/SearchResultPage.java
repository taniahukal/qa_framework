package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {

    @FindBy (xpath = "//div[@id='image_item59091640']")
    WebElement searchResult;

    private WebDriver webDriver;

    private WebDriverWait webDriverWait;

    private static final Long ELEMENT_WAIT_TIME_OUT = 30L;

    public SearchResultPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, ELEMENT_WAIT_TIME_OUT);
        PageFactory.initElements(webDriver, this);
    }

    public ProductDetailsPage clickOnSearchResult () {
        searchResult.click();
        return new ProductDetailsPage(webDriver);
    }
}
