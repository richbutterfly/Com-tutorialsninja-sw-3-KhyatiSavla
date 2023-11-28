package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * ● Create package laptopsandnotebooks
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 */
public class LaptopsAndNotebooksTest extends Utility {

    String baseURL = "http://tutorialsninja.com/demo/index.php?";

    //Method to open the browser
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        // 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //1.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
        String expectedOrder ="Price (High > Low)";
        String actualOrder = getTextFromElement(By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC']"));
        Assert.assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //2.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        //2.5 Verify the text “MacBook”
        Assert.assertEquals("MacBook",getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]")));
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedMessage = "Success: You have added MacBook to your shopping cart!";
        String actualMessage =getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expectedMessage,actualMessage);
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        Assert.assertEquals("Shopping Cart",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals("MacBook",getTextFromElement(By.xpath("(//a[contains(text(),'MacBook')])[2]")));
        //2.11 Change Quantity "2"
        clearText(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedMsg2 ="Success: You have modified your shopping cart!";
        String actualMsg2 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expectedMsg2,actualMsg2);
        //2.14 Verify the Total £737.45
        Assert.assertEquals("£737.45",getTextFromElement(By.xpath("(//td[contains(text(),'£737.45')])[4]")));
        //2.15 Click on “Checkout” button
        //2.16 Verify the text “Checkout”
        Assert.assertEquals("Checkout",getTextFromElement(By.xpath("//a[contains(text(),'Checkout')]")));
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.17 Verify the Text “New Customer”
        Assert.assertEquals("New Customer",getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]")));
        // 2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "Khyati");
        sendTextToElement(By.id("input-payment-lastname"), "Savla");
        sendTextToElement(By.id("input-payment-email"), "ksavla@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "4545455454");
        sendTextToElement(By.id("input-payment-address-1"), "34 Watkins Road");
        sendTextToElement(By.id("input-payment-city"), "London");
        sendTextToElement(By.id("input-payment-postcode"), "AB3 2CD");
        selectByVisibleTextFromDropdown(By.id("input-payment-country"), "United Kingdom");
        selectByVisibleTextFromDropdown(By.id("input-payment-zone"), "Bristol");
        //2.21 Click on “Continue” Button
        clickOnElement(By.id("button-guest"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"Successfully registered details.");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.name("agree"));
        //2.24 Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));
        //2.25 Verify the message “Warning: Payment method required!”
        String expectedMsg3 = "Warning: Payment method required!";
        String actualMsg3 = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals(expectedMsg3,actualMsg3);
    }


    //Method to close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
