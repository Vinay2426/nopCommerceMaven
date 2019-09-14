package GroupNopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Registration extends BasePage
{
       // protected static WebDriver driver;

        public String generateEmail(String startValue)      //this method will add new number to email every time you run so there will be new email each time
        {
            String email = startValue.concat(new Date().toString());
            //your code
            return  email;
        }
        public static String randomDate()       //this method will add new number to email every time you run so there will be new email each time
        {
            DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
            return format.format(new Date());
        }

        @BeforeMethod               //will execute before every method
        public void openBrowser()
        {
            System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

            //open the browser
            driver = new ChromeDriver();
            //maximise the browser window screen
            //driver.manage().window().fullscreen();
            driver.manage().window().maximize();
            //set implicit wait fro driver object
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //open the website
            driver.get("https://demo.nopcommerce.com/");
        }

        @AfterMethod                //will execute at the end of every method
        public void closeBrowser()
        {
            driver.close();      //will close the open browser
        }

        @Test
        public void registerAccount()       //account registration method has being done already in beforemethod here it will just compare the result
        {
            //click on register button
            driver.findElement(By.xpath("//a[@class='ico-register']")).click();
            //enter firstname
            driver.findElement(By.id("FirstName")).sendKeys("Venus");
            //enter lastname
            driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Patel");
            //enter email
            driver.findElement(By.name("Email")).sendKeys("test"+randomDate()+"@test.com");
            //Thread.sleep(2000); //it will wait for 2 seconds and will give result.
            //enter the password
            driver.findElement(By.id("Password")).sendKeys("test123");
            //confirm password
            driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
            //click on register to register the account
            driver.findElement(By.name("register-button")).click();

            String ExpectedResult = "Your registration completed";
            String ActualResult = driver.findElement(By.xpath("//div[@class='result']")).getText();
            Assert.assertEquals(ActualResult,ExpectedResult);
        }

}
