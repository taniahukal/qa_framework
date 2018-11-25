package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage {

    @FindBy (xpath = "//a[@class='novisited g-title-link wishlist-g-i-title-link']")
    WebElement wishlistItem;

    private WebDriver webDriver;

    private WebDriverWait webDriverWait;

    private static final Long ELEMENT_WAIT_TIME_OUT = 30L;

    public WishlistPage (final WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, ELEMENT_WAIT_TIME_OUT );
        PageFactory.initElements(webDriver, this);
    }

    public String getItemText () {
        return wishlistItem.getText();
    }
}
