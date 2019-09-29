package GroupNopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CheckNopCommerceAssertProdcuts extends Utils
{
    LoadProps loadProps = new LoadProps();

    @Test
    public void assertMethodToCheckAddToCartOfAllTheItemsOnHomepage()
    {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

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

        List<WebElement> listA = driver.findElements(By.className("item-box"));
        int count = 0;
        for (WebElement addCart : listA)
        {
            if (addCart.getAttribute("outerHTML").contains("Add to cart"))
            {
                count++;
            }
            else
            {
                System.out.println("no add to cart button" +addCart.getText());
            }
            Assert.assertEquals("Some of the item does not have add to cart button" +addCart.getSize(), count);

        }
    }

}
