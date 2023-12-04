package desktops;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DesktopsTest extends BaseTest {
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
    public void verifyProductArrangeInAlphabeticalOrder() {

        WebElement textDesktop = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        textDesktop.click();

        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div[1]/a");

        WebElement sortByPosition = driver.findElement(By.id("input-sort"));
        sortByPosition.click();

        Select select = new Select(sortByPosition);
        select.selectByIndex(2);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        WebElement textDesktop = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        textDesktop.click();

        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div[1]/a");

        WebElement sortByPosition = driver.findElement(By.id("input-sort"));
        sortByPosition.click();

        Select select = new Select(sortByPosition);
        select.selectByIndex(1);

        WebElement hpProduct = driver.findElement(By.xpath("//div[@id='content']/div[4]/div[3]/div/div[2]/div/h4/a"));
        hpProduct.click();

        String actualText = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
        String expectedText = "HP LP3065";
        Assert.assertEquals(actualText, expectedText);

        WebElement deliveryDate = driver.findElement(By.id("input-option225"));
        deliveryDate.clear();
        deliveryDate.sendKeys("2022-11-30");

        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("1");

        WebElement addToCartButton = driver.findElement(By.id("button-cart"));
        addToCartButton.click();

        Thread.sleep(1000);

        String actualText1 = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        System.out.println(actualText1);
        Assert.assertEquals(actualText1, expectedText1);

        Thread.sleep(1000);

        WebElement shoppingCartLink = driver.findElement(By.linkText("shopping cart"));
        shoppingCartLink.click();

        String actualText2 = driver.findElement(By.xpath("//ul[@class='breadcrumb']/li[2]/a")).getText();
        String expectedText2 = "Shopping Cart";
        Assert.assertEquals(actualText2, expectedText2);

        String actualText3 = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody[1]/tr[1]/td[2]/A")).getText();
        String expectedText3 = "HP LP3065";
        Assert.assertEquals(actualText3, expectedText3);

        String actualText4 = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody[1]/tr[1]/td[2]/small[1]")).getText();
        String expectedText4 = "Delivery Date:2022-11-30";
        Assert.assertEquals(actualText4, expectedText4);

        String actualText5 = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody[1]/tr[1]/td[3]")).getText();
        String expectedText5 = "Product 21";
        Assert.assertEquals(actualText5, expectedText5);

        String actualText6 = driver.findElement(By.xpath("//div[@id='content']/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
        String expectedText6 = "$122.00";
        Assert.assertEquals(actualText6, expectedText6);

    }

    @After
    public void endTest() {
        closeBrowser();
    }

}


