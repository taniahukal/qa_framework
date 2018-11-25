package GoogleTest;

import common.BaseTest;
import google.GoogleMainPage;
import google.SearchResultPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestSuite extends BaseTest {

    private WebDriver driver;


    @Test
    public void checkGoogleMainPageIsOpened () {
        final  String expectedTitle = "Google";
        driver.get("https://google.com");
        final String actualTitle = driver.getTitle();
        Assert.assertEquals("There is incorrect page title!", expectedTitle, actualTitle);
    }

    @Test
    public void  checkGoogleSearchFunctionality () {
        final String expectedFirstLinkText = "Компьютерная школа Hillel: курсы IT технологий";

        //1.Открыть гугл
        driver.get("http://google.com");

        //2.Создать объект главной стр гугл
        final GoogleMainPage page = new GoogleMainPage(driver);

        //3.Вводим искомое слово в поиск
        final SearchResultPage searchResultPage = page.typeSearchText("Hillel");

        //4.Возваращаем новую страницу с результатами поиска
        //final SearchResultPage searchResultPage = page.clickSearchButton();

        //Получаем текст первой ссылки со списка результатов
        final  String actualFirstLinkText = searchResultPage.getFirstSearchResultLinkText();

        //Сравниваем експектед и екшуал
        Assert.assertEquals("There is incorrect first link text displayed!",
                expectedFirstLinkText, actualFirstLinkText);
    }
}