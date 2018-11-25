package HotLineTest;

import common.BaseTest;
import hotline.AutoMotoPage;
import hotline.HotLineMainPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HotLineTestSuite extends BaseTest {

    @Test
    public void checkAutoMotoGoods () {
        final WebDriver webDriver = getDriver();
        final String[] expectedAutoMotoGoods = {

                "Автозапчасти",
                "Шины и диски",
                "Автозвук, видео, навигация",
                "Автоэлектрика и электроника",
                "Автохимия, масла",
                "Автооборудование",
                "Тюнинг",
                "Автомобили",
                "Мото, скутеры"
        };

        webDriver.get("https://hotline.ua/");

        final HotLineMainPage hotLineMainPage = new HotLineMainPage(webDriver);

        hotLineMainPage.clickAutoMotoLink();

        final AutoMotoPage autoMotoPage = new AutoMotoPage(webDriver);

        final List<String> actualAutoMotoGoods = autoMotoPage.getAutoMotoGoodsTextList();
        Assert.assertArrayEquals("There are incorrect items displayed!",
                expectedAutoMotoGoods, actualAutoMotoGoods.toArray());
    }
}
