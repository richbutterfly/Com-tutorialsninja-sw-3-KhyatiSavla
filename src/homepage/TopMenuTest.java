package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/** 1. create class "TopMenuTest"
 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 string
 1.2 This method should click on the menu whatever name is passed as parameter.
 Write the following Test:
 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 1.1 Mouse hover on “Desktops” Tab and click
 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 1.3 Verify the text ‘Desktops’
 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 2.3 Verify the text ‘Laptops & Notebooks’
 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 3.1 Mouse hover on “Components” Tab and click
 3.2 call selectMenu method and pass the menu = “Show All Components”
 3.3 Verify the text ‘Components’
 *
 */

public class TopMenuTest extends Utility {
String baseURL = "http://tutorialsninja.com/demo/index.php?";
    //Method to open the browser
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    public void selectMenu(String menu) {
        List<WebElement> allMenu = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']"));
        for (WebElement option : allMenu) {
            if (menu.equalsIgnoreCase(option.getText())) {
                option.click();
                break;
            }
        }
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
    //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
    //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");
    //1.3 Verify the text ‘Desktops’
        Assert.assertEquals("Desktops",getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']")));
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
    //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");
    //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals("Laptops & Notebooks",getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")));
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
    //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Components']"));
        clickOnElement(By.xpath("//a[contains(text(),'Show AllComponents')]"));
    //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
    //3.3 Verify the text ‘Components’
        Assert.assertEquals("Components",getTextFromElement(By.xpath("//h2[contains(text(),'Components')]")));
    }



    //Method to close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
