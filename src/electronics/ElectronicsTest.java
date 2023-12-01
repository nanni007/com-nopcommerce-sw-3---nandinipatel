package electronics;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.w3c.dom.Text;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //  1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //1.3 Verify the text “Cell phones”
        getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {
// 2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

//2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

//2.3 Verify the text “Cell phones”
        getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

//2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));

//2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));

//2.6 Verify the text “Nokia Lumia 1020”
        getTextFromElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));

// 2.7 Verify the price “$349.00”
        getTextFromElement(By.className("price actual-price"));

// 2.8 Change quantity to 2
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

// 2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[3]"));

//2.10 Verify the Message "The product has been added to your shopping cart" on Top
        getTextFromElement(By.xpath("//p[@class='content']"));

//2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.className("button-1 cart-button"));

//2.12 Verify the message "Shopping cart"
        getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));

//2.13 Verify the quantity is 2
        getTextFromElement(By.xpath("//input[@id='itemquantity11238']"));

//2.14 Verify the Total $698.00
        getTextFromElement(By.xpath("product-subtotal"));

//2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

//2.16 Click on “CHECKOUT”
        clickOnElement(By.className("button-1 checkout-button"));

//2.17 Verify the Text “Welcome, Please Sign In!”
        getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

//2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

//2.19 Verify the text “Register”
        getTextFromElement(By.xpath("//button[contains(text(),'Register')]"));

//2.20 Fill the mandatory fields
        clickOnElement(By.id("gender-female"));
        sendTextToElement(By.name("FirstName"), "prime");
        sendTextToElement(By.xpath("LastName"), "testing");
        selectByValueFromDropDown(By.xpath("//option[normalize-space()='9']"), "9");
        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "5");
        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1991");
        sendTextToElement(By.xpath("//input[@id='Email']"), "prime111@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Company']"), "Prime Ltd.");
        clickOnElement(By.xpath("//input[@id='Newsletter']"));
        sendTextToElement(By.xpath("//input[@id='Password']"), "123456789m");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "123456789m");


//2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

//2.22 Verify the message “Your registration completed”
        getTextFromElement(By.xpath("//div[@class='result']"));

//2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

//2.24 Verify the text “Shopping card”
        getTextFromElement(By.xpath("//span[contains(text(),'Shopping cart')]"));

//2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

//2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));


//2.27 Fill the Mandatory fields
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "147");
        clickOnElement(By.id("BillingNewAddress_StateProvinceId"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Dublin");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "53 Tudor Street, Roper Park");
        sendTextToElement(By.id("BillingNewAddress_Address2"), "Dublin, South Africa");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "RP 567KD");
        sendTextToElement(By.name("BillingNewAddress.PhoneNumber"), "+243567857896");
        sendTextToElement(By.id("BillingNewAddress_FaxNumber"), "(123)-456-7890");

//2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

//2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

//2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

//2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

//2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropDown(By.xpath("//option[@value='visa']"), "visa");

//2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "prime 123");
        sendTextToElement(By.id("CardNumber"), "4012 8888 8888 1881");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "9");
        selectByValueFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");

//2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

//2.35 Verify “Payment Method” is “Credit Card”
        getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));

//2.36 Verify “Shipping Method” is “2nd Day Air”
        getTextFromElement(By.xpath("//span[normalize-space()='2nd Day Air']"));

//2.37 Verify Total is “$698.00”
        getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));

//2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

//2.39 Verify the Text “Thank You”
        getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));

//2.40 Verify the message “Your order has been successfully processed!”
        getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));

//2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

//2.42 Verify the text “Welcome to our store”
        getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));

//2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));

//2.44 Verify the URL is “https://demo.nopcommerce.com/"
        driver.getCurrentUrl();
    }

    @After
    public void teardown() {
        closeBrowser();
    }
}
