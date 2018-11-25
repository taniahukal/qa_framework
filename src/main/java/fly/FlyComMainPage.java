package fly;

import javafx.beans.property.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class FlyComMainPage {

    @FindBy (xpath = "//input[@id='searchinput-from']")
    private WebElement fieldFrom;

    @FindBy (xpath = "//input[@id='searchinput-to']")
    private WebElement fieldTo;

    @FindBy (xpath = "//label[@for='datepicker-depart']")
    private WebElement departDate;

    @FindBy (xpath = "//button[@class='btn btn-primary btn-lg btn-block search_btn_big new_search_box']")
    private WebElement searchButton;

    @FindBy (xpath = "//label[@for='radio2']")
    private WebElement onewayRadioButton;

    @FindBy (xpath = "//a[@class='ui-datepicker-next ui-corner-all']")
    private WebElement nextButton;

    @FindBy (xpath = "//div[@class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']")
    private WebElement datePicker;

    @FindBy (xpath = "//button[@class='btn btn-primary btn-lg btn-block search_btn_big new_search_box']")
    private WebElement searchButtonFly;

    private static final String CURRENT_MONTH_AND_YEAR = "(//div[@class='ui-datepicker-title'])";

    private static final String CURRENT_DAYS = "(//table[@class='ui-datepicker-calendar']//td)";

    private WebDriver webDriver;

    private WebDriverWait webDriverWait;

    public FlyComMainPage (final WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void typeTextFrom (final String text) {
        fieldFrom.sendKeys(text, Keys.ENTER);
    }

    public void typeTextTo (final String text) {
        fieldTo.sendKeys(text, Keys.ENTER);
    }

    public void selectRadioButton () {
        onewayRadioButton.isSelected();
    }

    public void clickOnDepartDate () {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(departDate));
        departDate.click();
    }

    public void setMonthAndYear(final String monthAndYear) {
        while (!webDriver.findElement(By.xpath(CURRENT_MONTH_AND_YEAR)).getText().equalsIgnoreCase(monthAndYear));{
            webDriverWait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        }
    }

    public void setDay (final String expectedDay) {
        final String fullDayLocator = String.format(CURRENT_DAYS, expectedDay);
        final WebElement requiredDay = webDriver.findElement(By.xpath(fullDayLocator));
        requiredDay.click();
    }

    public FlightsResultPage clickOnSearchButton () {
        searchButtonFly.click();
        return new FlightsResultPage (webDriver);
    }

}
