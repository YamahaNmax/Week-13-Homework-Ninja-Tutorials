package laptopsandnotebooks;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LaptopsAndNotebooksTest extends BaseTest {

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
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        WebElement laptopNotebookTab = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        laptopNotebookTab.click();

        selectMenu("//ul[@class='nav navbar-nav']/li[2]/div[1]/a");

        WebElement sortByPosition = driver.findElement(By.id("input-sort"));
        sortByPosition.click();

        Select select = new Select(sortByPosition);
        select.selectByIndex(4);

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        WebElement laptopNotebookTab = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        laptopNotebookTab.click();

        selectMenu("//ul[@class='nav navbar-nav']/li[2]/div[1]/a");

        WebElement sortByPosition = driver.findElement(By.id("input-sort"));
        sortByPosition.click();

        Select select = new Select(sortByPosition);
        select.selectByIndex(4);

        WebElement macBook = driver.findElement(By.xpath("//div[@id='content']/div[4]/div[4]/div[1]/div[2]/div[1]/h4/a"));
        macBook.click();

        String actualText = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
        String expectedText = "MacBook";
        Assert.assertEquals(actualText, expectedText);

        WebElement addToCartButton = driver.findElement(By.id("button-cart"));
        addToCartButton.click();

//        String actualText1 = driver.findElement(By.xpath("//div[@id='product-product']/div[1]/a[1]")).getText();
//        String expectedText1 = "Success: You have added MacBook to your shopping cart!\n" +
//                "×";
//        System.out.println(actualText1);
//        Assert.assertEquals(actualText1, expectedText1);

        Thread.sleep(1000);

        WebElement shoppingCartLink = driver.findElement(By.linkText("shopping cart"));
        shoppingCartLink.click();

        String actualText2 = driver.findElement(By.xpath("//ul[@class='breadcrumb']/li[2]/a")).getText();
        String expectedText2 = "Shopping Cart";
        Assert.assertEquals(actualText2, expectedText2);

        String actualText3 = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody[1]/tr[1]/td[2]/A")).getText();
        String expectedText3 = "MacBook";
        Assert.assertEquals(actualText3, expectedText3);

        WebElement qty = driver.findElement(By.xpath("//div[@class='input-group btn-block']/input[1]"));
        qty.clear();
        qty.sendKeys("2");

        WebElement updateButton = driver.findElement(By.xpath("//div[@class='input-group btn-block']/span[1]/button[1]"));
        updateButton.click();

        String actualText4 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div[1]")).getText();
        String expectedText4 = "Success: You have modified your shopping cart!\n" +
                "×";
        Assert.assertEquals(actualText4, expectedText4);

        String actualText5 = driver.findElement(By.xpath("//div[@id='content']/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
        String expectedText5 = "$1,204.00";
        Assert.assertEquals(actualText5, expectedText5);

        WebElement checkoutButton = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[2]/a[1]"));
        checkoutButton.click();

        String actualText6 = driver.findElement(By.xpath("//div[@id='checkout-checkout']/div[1]/div[1]/h1")).getText();
        String expectedText6 = "Checkout";
        Assert.assertEquals(actualText6, expectedText6);

        Thread.sleep(1000);

        String actualText7 = driver.findElement(By.xpath("//div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2")).getText();
        String expectedText7 = "New Customer";
        Assert.assertEquals(actualText7, expectedText7);

        WebElement guestButton = driver.findElement(By.xpath("//div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label/input"));
        guestButton.click();

        WebElement continueButton = driver.findElement(By.xpath("//div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input"));
        continueButton.click();




    }

    @After
    public void endTest() {
        closeBrowser();
    }

}


