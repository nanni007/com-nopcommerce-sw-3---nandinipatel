package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        // WebElement loginLink = driver.findElement(by);
        // loginLink.click();
        driver.findElement(by).click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
}
