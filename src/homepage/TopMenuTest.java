package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    @Test
    public void selectMenu(String menu, int i) {
        //1.2 This method should click on the menu whatever name is passed as parameter.
clickOnElement(By.xpath("//ull[@class='top-menu notmobile'/li/a[normalize-space()=']" + menu + ""));
String actualText = getTextFromElement(By.xpath("div[@class='page-title']/h1"));

String [] expectedText = {"Computers", "Electronics", "Apparel", "Digital Downloads", "Books", "Jewelry", "Gift Cards"}
        Assert.assertEquals();
    }

    //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation() {

        String[] topMenuArray = new String[7];
        int i = 0;
        List<WebElement> topMenu = driver.findElements(By.xpath("//ull[@class='top-menu notmobile'/li"));

        for (WebElement topMenuItem : topMenu) {
            topMenuArray[i] = topMenuItem.getText();
            i++;
        }
    }

    @After
    public void teardown() {
        closeBrowser();
    }
}
