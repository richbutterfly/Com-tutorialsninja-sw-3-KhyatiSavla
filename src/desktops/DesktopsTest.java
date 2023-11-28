package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * ● Create the package name desktops
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73"
 */
public class DesktopsTest extends Utility {

    String baseURL = "http://tutorialsninja.com/demo/index.php?";

    //Method to open the browser
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//label[contains(text(),'Sort By:')]"));
        selectByValueFromDropdown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        String expectedOrder = "Name (Z - A)";
        String actualOrder = getTextFromElement(By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']"));
        Assert.assertEquals(expectedOrder, actualOrder);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Currency Dropdown and click
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        //2.2 Mouse hover on £Pound Sterling and click
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'£Pound Sterling')]"));
        //2.3 Mouse hover on Desktops Tab.
        mouseHoverToElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        //2.4 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops'])"));
        //2.5 Select Sort By position "Name: A to Z"
        mouseHoverToElementAndClick(By.xpath("//select[@id='input-sort']"));
        clickOnElement(By.xpath("//option[text()='Name (A - Z)']"));
        //2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.7 Verify the Text "HP LP3065"
        Assert.assertEquals("HP LP3065", getTextFromElement(By.xpath("//a[normalize-space()='HP LP3065']")));
        //2.8 Select Delivery Date "2023-11-27"
        String year = "2023";
        String month = "11";
        String date = "27";
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']")); // Opening the calendar
        while (true) {
            String monthYear = getTextFromElement(By.xpath("//input[@id='input-option225']"));
            System.out.println(monthYear);
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
            }
            // Select the date
            List<WebElement> allDates = driver.findElements(By.xpath("//tbody/tr/td"));
            for (WebElement dt : allDates) {
                if (dt.getText().equalsIgnoreCase(date)) {
                    dt.click();
                    break;
                }
                //2.9.Enter Qty "1” using Select class.
                clearText(By.id("input-quantity"));
                sendTextToElement(By.id("input-quantity"), "1");
                //2.10 Click on “Add to Cart” button
                clickOnElement(By.xpath("//button[@id='button-cart']"));
                //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
                String expectedMsg = "Success: You have added HP LP3065 to your shopping cart!";
                String actualMsg = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
                //2.12 Click on link “shopping cart” display into success message
                clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
                //2.13 Verify the text "Shopping Cart"
                Assert.assertEquals("Shopping Cart ", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));
                //2.14 Verify the Product name "HP LP3065"
                Assert.assertEquals("HP LP3065", getTextFromElement(By.xpath("(//a[contains(text(),'HP LP3065')])[2]")));
                //2.15 Verify the Delivery Date "2023-11-27"
                Assert.assertEquals("2023-11-27", getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']")));
                //2.16 Verify the Model "Product21"
                Assert.assertEquals("Product21", getTextFromElement(By.xpath("//td[normalize-space()='Product 21']")));
                //2.17 Verify the Total "£74.73"
                Assert.assertEquals("", getTextFromElement(By.xpath("(//td[contains(text(),'£74.73')])[5]")));
            }
        }


    }

    //Method to close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
