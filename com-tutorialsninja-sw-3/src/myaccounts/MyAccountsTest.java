package myaccounts;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountsTest extends BaseTest {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    public void selectMyAccountOptions(String option) {
        WebElement menuLink = driver.findElement(By.linkText(option));
        menuLink.click();

    }

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        WebElement myAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myAccount.click();

        selectMyAccountOptions("Register");

        String actualText = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/h1")).getText();
        String expectedText = "Register Account";
        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        WebElement myAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myAccount.click();

        selectMyAccountOptions("Login");

        String actualText = driver.findElement(By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/h2")).getText();
        String expectedText = "Returning Customer";
        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        WebElement myAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myAccount.click();

        selectMyAccountOptions("Register");

        WebElement firstName = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/fieldset[1]/div[2]/div[1]/input[1]"));
        firstName.sendKeys("Miten");

        WebElement lastName = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/fieldset[1]/div[3]/div[1]/input[1]"));
        lastName.sendKeys("Patel");

        WebElement email = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/fieldset[1]/div[4]/div[1]/input[1]"));
        email.sendKeys("m4mitzcodebuster50000000@gmail.com");

        WebElement telephone = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/fieldset[1]/div[5]/div[1]/input[1]"));
        telephone.sendKeys("0123456789");

        WebElement password = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/fieldset[2]/div[1]/div[1]/input[1]"));
        password.sendKeys("Codebuster@1234");

        WebElement confirmPassword = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/fieldset[2]/div[2]/div[1]/input[1]"));
        confirmPassword.sendKeys("Codebuster@1234");

        WebElement subscribe = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/fieldset[3]/div[1]/div[1]/label/input[1]"));
        subscribe.click();

        WebElement privacyPolicies = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/div[1]/div[1]/input[1]"));
        privacyPolicies.click();

        WebElement continueButton = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/div[1]/div[1]/input[2]"));
        continueButton.click();

        Thread.sleep(1000);

        String actualText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedText = "Your Account Has Been Created!";
        Assert.assertEquals(actualText, expectedText);

        WebElement continueButton1 = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[1]/a"));
        continueButton1.click();

        WebElement myLoggedInAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myLoggedInAccount.click();

        selectMyAccountOptions("Logout");

        Thread.sleep(1000);

        String actualText1 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedText1 = "Account Logout";
        Assert.assertEquals(actualText1, expectedText1);

        WebElement continueButton2 = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[1]/a"));
        continueButton2.click();

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

        WebElement myAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myAccount.click();

        selectMyAccountOptions("Login");

        WebElement email = driver.findElement(By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]"));
        email.sendKeys("m4mitzcodebuster50000000@gmail.com");

        WebElement password = driver.findElement(By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]"));
        password.sendKeys("Codebuster@1234");

        WebElement continueButton = driver.findElement(By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        continueButton.click();

        String actualText = driver.findElement(By.xpath("//div[@id='content']/h2[1]")).getText();
        String expectedText = "My Account";
        Assert.assertEquals(actualText, expectedText);

        WebElement myLoggedInAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myLoggedInAccount.click();

        selectMyAccountOptions("Logout");

        Thread.sleep(1000);

        String actualText1 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedText1 = "Account Logout";
        Assert.assertEquals(actualText1, expectedText1);

        WebElement continueButton2 = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[1]/a"));
        continueButton2.click();

    }


    @After
    public void endTest() {
        closeBrowser();
    }

}
