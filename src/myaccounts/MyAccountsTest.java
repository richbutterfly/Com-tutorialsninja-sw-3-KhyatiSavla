package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/** ● Create package myaccounts
 1. Create the class MyAccountsTest
 1.1 create method with name "selectMyAccountOptions" it has one parameter name
 "option" of type string
 1.2 This method should click on the options whatever name is passed as parameter.
 (Hint: Handle List of Element and Select options)
 Write the following test
 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 1.1 Clickr on My Account Link.
 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Register”
 1.3 Verify the text “Register Account”.
 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 2.1 Clickr on My Account Link.
 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Login”
 2.3 Verify the text “Returning Customer”.
 3. Test name verifyThatUserRegisterAccountSuccessfully()
 3.1 Clickr on My Account Link.
 3.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Register”
 3.3 Enter First Name
 3.4 Enter Last Name
 3.5 Enter Email
 3.6 Enter Telephone
 3.7 Enter Password
 3.8 Enter Password Confirm
 3.9 Select Subscribe Yes radio button
 3.10 Click on Privacy Policy check box
 3.11 Click on Continue button
 3.12 Verify the message “Your Account Has Been Created!”
 3.13 Click on Continue button
 3.14 Clickr on My Account Link.
 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 “Logout”
 3.16 Verify the text “Account Logout”
 3.17 Click on Continue button
 *
 */
public class MyAccountsTest extends Utility {

    String baseURL = "http://tutorialsninja.com/demo/index.php?";

    //Method to open the browser
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class = 'list-inline']//a"));
        for (WebElement list : options) {
            if (option.equalsIgnoreCase(list.getText())) {
                list.click();
                break;
            }
        }
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//a[@title='My Account']"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals("Register Account", getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]")));
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//a[@title='My Account']"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals("Returning Customer", getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]")));
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//a[@title='My Account']"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"), "Khyati");
        //3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"), "Savla");
        //3.5 Enter Email
        sendTextToElement(By.id("input-email"), "ksavla@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.name("telephone"), "4545455454");
        //3.7 Enter Password
        sendTextToElement(By.id("input-password"), "7890");
        //3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "7890");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//h2[contains(text(),'My Account')]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals("Logout", getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']")));
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//a[@title='My Account']"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"),"ksavla@gmail.com");
        //4.5 Enter Password
        sendTextToElement(By.id("input-password"),"7890");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        Assert.assertEquals("My Account", getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']")));
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        Assert.assertEquals("Logout", getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']")));
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }


    //Method to close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
