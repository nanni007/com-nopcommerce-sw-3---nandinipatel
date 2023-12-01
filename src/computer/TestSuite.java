package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;
import utilities.Utility;
import zmq.socket.radiodish.Radio;

import java.util.ArrayList;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Click on Computer Menu
        WebElement computer = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[.='Computers ']"));
        //1.2 Click on Desktop
        WebElement desktop = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Desktops')]"));
        //  1.3 Select Sort By position "Name: Z to A"


        //  1.4 Verify the Product will arrange in Descending order.
        List<WebElement> filteredProducts = driver.findElements(By.xpath("//div[@class='details']//h2"));

        for (WebElement e : filteredProducts) {
            System.out.println(e.getText());
        }
        List<String> filteredProductList = new ArrayList<>();
        for (WebElement items : filteredProducts) {
            filteredProductList.add(items.getText());
        }


        Actions actions = new Actions(driver);
        // 2.1 Click on Computer Menu.
        actions.moveToElement(computer).build().perform();

        //2.2 Click on Desktop
        actions.moveToElement(desktop).click().build().perform();

        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.name("products-orderby"));
        selectByValueFromDropDown(By.xpath("//select[@id='products-orderby']"), "6");

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));

        //2.5 Verify the Text "Build your own computer"
        String actualText = getTextFromElement(By.xpath("//a[contains(text(),'Build your own computer')]"));
        String expectedText = "Build your own computer";
        Assert.assertEquals(expectedText, actualText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.id("product_attribute_1"));
        selectByValueFromDropDown(By.xpath("//option[@value='1']"), "1");

        //2.7.Select "8GB [+$60.00]" using Select class
        clickOnElement(By.name("product_attribute_2"));
        selectByValueFromDropDown(By.xpath("//option[@value='5']"), "5");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.name("product_attribute_4"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_10"));
        clickOnElement(By.id("product_attribute_5_12"));

        //2.11 Verify the price "$1,475.00"
        String actualText1 = getTextFromElement(By.className("price-value-1"));
        String expectedText1 = "$1,475.00";
        Assert.assertEquals(expectedText1, actualText1);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualText2 = getTextFromElement(By.xpath("//p[@class='content']"));
        String expectedText2 = "The product has been added to your shopping cart";
        Assert.assertEquals(expectedText2, actualText2);


        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));

        //2.15 Verify the message "Shopping cart"
        String actualText3 = getTextFromElement(By.cssSelector("div[class='page-title'] h1"));
        String expectedText3 = "Shopping cart";
        Assert.assertEquals(expectedText3, actualText3);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        sendTextToElement(By.name("itemquantity11234"), "2");

        //2.17 Verify the Total"$2,950.00"
        String actualText4 = getTextFromElement(By.xpath("//tr[@class='order-total']//span[@class='value-summary']" + "is the total"));
        String expectedText4 = "$2,950.00";
        Assert.assertEquals(expectedText4, actualText4);

        // 2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String actualText5 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        String expectedText5 = "Welcome, Please Sign In!";
        Assert.assertEquals(expectedText5, actualText5);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Testing");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "prime123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"), "Prime Testing Team");
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "0");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Manchester");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "123 St Patrick Street");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address2']"), "Manchester, UK");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "MB23 45ST");
        sendTextToElement(By.className("BillingNewAddress.PhoneNumber"), "+44234567899");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']"), "+44-20-1224-3456");

        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.name("shippingoption"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.id("//button[@class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Tom Markwell");
        sendTextToElement(By.name("CardNumber"), "1234123412341234");
        selectByValueFromDropDown(By.name("ExpireMonth"), "4");
        selectByValueFromDropDown(By.name("ExpireYear"), "2025");
        sendTextToElement(By.className("field-validation-valid"), "123");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        String actualText6 = getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
        String expectedText6 = "Credit Card";
        Assert.assertEquals(expectedText6, actualText6);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String actualText7 = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        String expectedText7 = "Next Day Air";
        Assert.assertEquals(expectedText7, actualText7);

        //2.33 Verify Total is “$2,950.00”
        String actualText8 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        String expectedText8 = "$2,950.00";
        Assert.assertEquals(expectedText8, actualText8);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.35 Verify the Text “Thank You”
        String actualText9 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        String expectedText9 = "Thank You";
        Assert.assertEquals(expectedText9, actualText9);

        //2.36 Verify the message “Your order has been successfully processed!”
        String actualText10 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        String expectedText10 = "Your order has been successfully processed!";
        Assert.assertEquals(expectedText10, actualText10);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        // 2.37 Verify the text “Welcome to our store”
        String actualText11 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        String expectedText11 = "Welcome to our store";
        Assert.assertEquals(expectedText11, actualText11);


    }

    @After
    public void teardown() {
        closeBrowser();
    }

}
