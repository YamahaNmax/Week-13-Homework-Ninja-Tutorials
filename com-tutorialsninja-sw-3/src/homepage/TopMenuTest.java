package homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    public void selectMenu(String menu) {
        WebElement menuLink = driver.findElement(By.xpath(menu));
        menuLink.click();

    }

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        WebElement textDesktop = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        textDesktop.click();

        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div[1]/a");

        String actualText = driver.findElement(By.tagName("h2")).getText();
        String expectedText = "Desktops";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        WebElement laptopNotebookTab = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        laptopNotebookTab.click();

        selectMenu("//ul[@class='nav navbar-nav']/li[2]/div[1]/a");

        String actualText = driver.findElement(By.tagName("h2")).getText();
        String expectedText = "Laptops & Notebooks";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        WebElement textDesktop = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a"));
        textDesktop.click();

        selectMenu("//ul[@class='nav navbar-nav']/li[3]/div[1]/a");

        String actualText = driver.findElement(By.tagName("h2")).getText();
        String expectedText = "Components";
        Assert.assertEquals(actualText, expectedText);
    }

    @After
    public void endTest() {
        closeBrowser();
    }

}
