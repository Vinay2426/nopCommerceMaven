package GroupNopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class checkNopCommerceAssertProducts extends Utils
{
    LoadProps loadProps = new LoadProps();

    @Test
    public void assertMethodToCheckAddToCartOfAllTheItemsOnHomepage()
    {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver1.exe");

        SoftAssert softAssert = new SoftAssert();

        //open the browser
        driver = new ChromeDriver();
        //maximise the browser window screen
        //driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        //set implicit wait fro driver object
        implicitWaitTime(10);
        //open the website // "url" is called from testdataConfig.properties
        getUrl("url");

        //locator will select the all the items from DOM
        //List<WebElement> listA = driver.findElements(By.className("item-box"));
        List<WebElement> listA = driver.findElements(By.className("product-item"));

        //it will print how many locator are with path
        System.out.println(listA.size());
        System.out.println(listA);

        //declare and initialise int for 'foreach' loop
        int count = 0;
        for (WebElement addCart : listA)
        {
            //get Attribute from outer HTML which has word add to cart
            if (addCart.getAttribute("outerHTML").contains("Add to cart"))
            {
                //count++ will check all the listA webelement which has add to cart text in locator
                count++;
            }
            else
            {
                // this message will print the list of products if any of the locator has not add to cart text
                System.out.println("no add to cart button" + " " +addCart.getText());
            }
        }
        //print total locator which has add to cart
        System.out.println(count);
        //assert will check the result
        Assert.assertEquals(listA.size(), count);
    }
        @AfterMethod
        public void quitBrowser ()
        {
            driver.quit();
        }
}
