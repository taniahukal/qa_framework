package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {


    @FindBy (xpath = "//a[@class=\"detail-wishlist-link novisited sprite-side\"]")
    WebElement heartButton;

    @FindBy (xpath = "//input[@name='login' and contains (@class, 'input-text wishlists-i-input')]")
    WebElement loginField;

    @FindBy (xpath = "//span[@class='btn-link btn-link-green wishlists-submit-btn']")
    WebElement saveButton;

    @FindBy (xpath = "//input[@class='input-text wishlists-i-input' and contains (@name, 'fio')]")
    WebElement fioField;

    @FindBy (xpath = "//button[@name='confirm_signup_submit']")
    WebElement submitButton;

    @FindBy (xpath = "//a[@class='hub-i-link hub-i-wishlist-link-count sprite-side whitelink']")
    WebElement wishlistButton;

    private WebDriver webDriver;

    private WebDriverWait webDriverWait;

    private static final Long ELEMENT_WAIT_TIME_OUT = 30L;

    public ProductDetailsPage (final WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, ELEMENT_WAIT_TIME_OUT );
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnHeartButton () {
        heartButton.click();
    }

    public void typeTextToLoginField (final String text) {
        loginField.sendKeys(text);
    }

    public void clickOnSaveButton () {
        saveButton.click();
    }

    public void typeTextToFioField (final String text) {
        fioField.sendKeys(text);
    }

    public void clickOnSubmitButton () {
        submitButton.click();
    }

    public WishlistPage clickOnWhishlistButton () {
        wishlistButton.click();
        return new WishlistPage (webDriver);
    }
}
