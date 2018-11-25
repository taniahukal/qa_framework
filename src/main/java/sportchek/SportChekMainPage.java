package sportchek;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

    public class SportChekMainPage {

        @FindBy (xpath = "//span[@class='menu-toggle__text']")
        private WebElement burgerButton;

        @FindBys({
                @FindBy(xpath = "//ul[@class='page-nav__list page-nav__list_short main-menu']//li[@class='page-nav__item']")
        })
        private List<WebElement> filterItems;

        @FindBy (xpath = "//div[@class='header-account drawer-ui drawer-ui_state_dropdown' and contains (@data-module-type, 'HeaderAccountButtonNoFB')]")
        private WebElement SignInButton;

        @FindBy (xpath = "//a[@class='header-account__sign-in__register__link']")
        private WebElement registerNowLink;

        @FindBy (xpath = "//input[@name='login'] [1]")
        private WebElement email;

        @FindBy(xpath = "//input[@name='loginConfirmation']")
        private WebElement confirmEmail;

        @FindBy(xpath = "//input[@class='register-form__password']")
        private WebElement password;

        @FindBy(xpath = "//input[@class='register-form__password-confirm']")
        private WebElement confirmPassword;

        @FindBy(xpath = "//span[@for='login']")
        private WebElement errorLogin;

        @FindBy(xpath = "//span[@for='loginConfirmation']")
        private WebElement errorLoginConfirmation;

        @FindBy(xpath = "//span[@for='password']")
        private WebElement errorPassword;

        @FindBy(xpath = "//span[@for='confirmPassword']")
        private WebElement errorPasswordConfirm;

        private WebDriver webDriver;

        private WebDriverWait webDriverWait;

        public SportChekMainPage(final WebDriver driver) {
            this.webDriver = driver;
            webDriverWait = new WebDriverWait(driver, 30);
            PageFactory.initElements(webDriver, this);
        }

        public void expandFilterBox () {
            webDriverWait.until(ExpectedConditions.visibilityOf(burgerButton)).click();
        }

        public List<String> getFilterItemsTextList () {
            final List<String> filterItemsTextList = new ArrayList<String>();
            for (final WebElement element : filterItems) {
                filterItemsTextList.add(element.getText());
            }
            return filterItemsTextList;
        }

        public void expandSignInForm () { SignInButton.click(); }

        public void clickOnRegisterNowLink () {
            registerNowLink.click();
        }

        public void typeEmail (final String text) {
            email.sendKeys(text, Keys.ENTER);
        }

        public void typeConfirmEmail (final String text) {
            confirmEmail.sendKeys(text, Keys.ENTER);
        }

        public void  typePassword (final String text) {
            password.sendKeys(text, Keys.ENTER);
        }

        public void typeConfirmPassword (final String text) {
            confirmPassword.sendKeys(text, Keys.ENTER);
        }

        public String getEmailError () {
            return errorLogin.getText();
        }

        public String getEmailConfirmationError () {
            return errorLoginConfirmation.getText();
        }

        public String getPasswordError () {
            return errorPassword.getText();
        }

        public String getPasswordConfirmationError () {
            return errorPasswordConfirm.getText();
        }
    }
