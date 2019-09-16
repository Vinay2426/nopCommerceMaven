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

public class Registration extends Utils             //Utils class is already a child class of BasePage class
{
    // protected static WebDriver driver;           //we have extends BasePage where we have already based the webDriver
    LoadProps loadProps = new LoadProps();

    @BeforeMethod           //will enter the url
        public void openBrowser() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");
        //open the browser
        driver = new ChromeDriver();
        //maximise the browser window screen
        //driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        //set implicit wait fro driver object
        fixedImplicitWaitTime(10);
        //open the website // "url" is called from testdataConfig.properties
        driver.get(loadProps.getProperty("url"));
    }
    @AfterMethod                //will execute at the end of every method
    public void closeBrowser()
    {
        driver.quit();      //will quit the open browser
    }
    @Test
    public void registerAccount()
    {
        //click on register button
        clickOnElements(By.xpath("//a[@class='ico-register']"));
        //enter firstname, loadprops will obtain name from it.
        enterText(By.id("FirstName"), loadProps.getProperty("FirstName"));
        //enter lastname
        enterText(By.xpath("//input[@name='LastName']"), loadProps.getProperty("LastName"));
        //enter date of birth
        //date
        selectByVisibleNumber(By.xpath("//select[@name = 'DateOfBirthDay']"),(20));
        //month
        selectByVisibleNumber(By.xpath("//select[@name = 'DateOfBirthMonth']"),(6));
        //year
        selectByVisibleText(By.xpath("//select[@name = 'DateOfBirthYear']"),("2000"));
        //enter email
        enterText(By.name("Email"),"test"+randomDate()+"@test.com");
        //enter the password
        enterText(By.id("Password"),loadProps.getProperty("Password"));
        //confirm password
        enterText(By.id("ConfirmPassword"), loadProps.getProperty("Password"));
        //click on register to register the account
        clickOnElements(By.name("register-button"));
        //assert method to check
        assertMethod((By.xpath("//div[@class='result']")), "Your registration completed");
    }
    @Test
    public void emailAFriend()
    {
        //click on register button
        clickOnElements(By.xpath("//a[@class='ico-register']"));
        //enter firstname
        enterText(By.id("FirstName"),"Venus");
        //enter lastname
        enterText(By.xpath("//input[@name='LastName']"),"Patel");
        //enter email
        enterText(By.name("Email"), "test"+randomDate()+"@test.com");
        //enter the password
        enterText(By.id("Password"),"test123");
        //confirm password
        enterText(By.id("ConfirmPassword"),"test123");
        //click on register to register the account
        clickOnElements(By.name("register-button"));
        //click on continue and it will lead to the homepage
        clickOnElements(By.xpath("//input[@name='register-continue']"));
        clickOnElements(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-grid']//div[2]//div[1]//div[1]//a[1]//img[1]"));
        //click on email a friend
        clickOnElements(By.xpath("//input[@value='Email a friend']"));
        //fill friend's email address
        enterText(By.id("FriendEmail"),"testtest123456@test.com");
        //fill personal message
        enterText(By.name("PersonalMessage"),"This very good deal mate, don't need to miss it. go ahead and buy it");
        //click on send email
        clickOnElements(By.name("send-email"));
        //message end of the process
        String ExpectedResult = "Email a friend";
        //message locator
        String ActualResult = getText(By.xpath("//h1"));
        //compare Actual result to expected result
        Assert.assertEquals(ActualResult,ExpectedResult);
    }
    @Test
    public void selectCameraAndPhoto()
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
        //click on continue and it will lead to the homepage
        driver.findElement(By.xpath("//input[@name='register-continue']")).click();
        //select on Electrics
        driver.findElement(By.xpath("//h2[@class='title']//a[contains(text(),'Electronics')]")).click();
        //click on Camera & photo
        driver.findElement(By.xpath("//img[@alt='Picture for category Camera & photo']")).click();
        //message end of the process
        String ExpectedResult = "Camera & photo";
        //locator for actual result
        String ActualResult = driver.findElement(By.xpath("//h1[contains(text(),'Camera & photo')]")).getText();
        //compare the actual with expected result
        Assert.assertEquals(ActualResult,ExpectedResult);
    }
    @Test
    public void userShouldBeFilterJewellery()
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
        //click on continue and it will lead to the homepage
        driver.findElement(By.xpath("//input[@name='register-continue']")).click();
        //select jewllery option
        driver.findElement(By.linkText("Jewelry")).click();
        //click on Filter by price $700-$3000
        driver.findElement(By.xpath("//a[contains(@href, '700-3000')]")).click();

        //comparing actual and expected result
        String Expectedresult="$700.00 - $3,000.00";
        String Actualresult= driver.findElement(By.xpath("//span[@class='item']")).getText();
        Assert.assertEquals(Actualresult,Expectedresult);
        String Productprice=driver.findElement(By.xpath("//span[@class='price actual-price']")).getText();

        String price1=String.valueOf(Productprice.replace("$",""));
        String price2=String.valueOf(price1.replace(",",""));
        double price=Double.valueOf(price2);

        Assert.assertTrue(price>=700 && price<=3000);
    }
    @Test
    public void AddBooksToShoppingBasket() throws InterruptedException
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
        //click on continue and it will lead to the homepage
        driver.findElement(By.xpath("//input[@name='register-continue']")).click();
        //click(select) Books category
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']")).click();
        //add first book to cart
        driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();
        //pause for few seconds
        Thread.sleep(2000);
        //add second book to cart
        driver.findElement(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();
        Thread.sleep(5000);
        //click on Shopping cart
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        //to check the result we will compare the two books cost with actual cost of the books
        String ExpectedResult = "$78.00";
        //locator for actual result
        String ActualResult = driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$78.00')]")).getText();
        //compare the actual with expected result
        Assert.assertEquals(ActualResult,ExpectedResult);
    }
}
