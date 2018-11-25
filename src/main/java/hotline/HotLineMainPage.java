package hotline;

import google.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotLineMainPage {

    @FindBy (xpath = "//a[@href='/auto/']")
    private WebElement autoMotoLink;

    private WebDriver webDriver;

    private WebDriverWait webDriverWait;

    private static final Long ELEMENT_WAIT_TIME_OUT = 30L;

    public HotLineMainPage (final WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, ELEMENT_WAIT_TIME_OUT );
        PageFactory.initElements(webDriver, this);
    }

    public AutoMotoPage clickAutoMotoLink () {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(autoMotoLink));
        autoMotoLink.click();
        return new AutoMotoPage (webDriver);
    }
}
