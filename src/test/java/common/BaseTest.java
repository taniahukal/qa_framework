package common;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

    public class BaseTest {

        public WebDriver getDriver() {
            return driver;
        }

        private WebDriver driver;

        @Before
        public void setDriver () {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @After
        public void driverClose () {
            driver.close();
        }
    }
