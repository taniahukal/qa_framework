package hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AutoMotoPage {

    @FindBys({
            @FindBy (xpath = "//ul[@class='cell-navigation cell-navigation-tree']//li[@class='item']")
    })
    private List<WebElement> autoMotoGoods;

    private WebDriver webDriver;

    public  AutoMotoPage (final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getAutoMotoGoodsTextList () {
        final List<String> autoMotoGoodsTextList = new ArrayList<String>();
        for (final WebElement element : autoMotoGoods) {
            autoMotoGoodsTextList.add(element.getText());
        }
        return autoMotoGoodsTextList;
    }
}
