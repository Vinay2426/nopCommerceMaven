package GroupNopCommerce;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.concurrent.TimeUnit;

public class Utils extends BasePage             //BasePage is parent class
{
    //(1) it will click on elements
    public void clickOnElements(By by)
    {
        driver.findElement(by).click();
    }
    //(2) Clear Text form inout box/area
    public void clearInputText(By by)
    {
        driver.findElement(by).clear();
    }
    //(3) to enter text of element
    public void enterText (By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    //(4) Clear and enter text in input field
    public void clearAndInputText(By by, String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    //(5) to get the text for expected and actual result
    public String getText(By by)
    {
        return driver.findElement(by).getText();
    }
    //(6) Checking WebElement present/exist in DOM
    public boolean webElementPresent(By by)
    {
        return driver.findElements(by).size()!=0;
    }
    //(7) Checking WebElemnt displayed or not
    public boolean webElementDisplayedInDOM(By by)
    {
        return driver.findElement(by).isDisplayed();
    }
    //(8) Wait for fixed time given in seconds(implicit wait)
    public void fixedImplicitWaitTime(long time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    //(9) Try to click element multiple times if not available in first go
    public void tryClickingMultipleTime(By by, int times)
    {
        driver.findElements(by).get(times).click();
    }
    //(10) is dropdown present
    public void dropDownPresent(By by, String text)
    {
        Select select = new Select(driver.findElement(by));
        select.getOptions();
    }
    //(11) Wait for locator to be clickable for given time in seconds
    public static void waitForClickable(By by,long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //(12) Wait for element to be clickable for given time in seconds
    public static void waitForElementVisible(By by,long time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    //Wait for element for given time in second
    //(13) wait till certain alert message/window appears which no locator
    public static void waitForAlertPresent(By by,long time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //(14) wait for element to be invisible
    public static void waitForAlertInvisible(By by,long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    // (15) select from visible text DROPDOWN
    public void selectByVisibleText(By by, String text)
    {
        Select select = new Select (driver.findElement(by));
        select.selectByVisibleText(text);
    }
    //(16) Select by Index number DROPDOWN
    public void selectByVisibleNumber(By by, int number)
    {
        Select select = new Select (driver.findElement(by));
        select.selectByIndex(number);
    }
    //(17) Select from the value DROPDOWN
    public void selectByValue(By by, String value)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    //(18) Select from first selected option
    public void selectByFirstSelectedOption(By by, String value)
    {
        Select select = new Select(driver.findElement(by));
        select.getFirstSelectedOption();
    }
    //(19) Assert method to compare results
        public void assertMethod(By actual, String expected)
        {
            Assert.assertEquals(getText(actual),expected);
        }

    //(20) Scroll to view element
    public void scrollWebpageToViewElement(By by)
    {
        Actions actions = new Actions(driver);
        //driver.findElement(by).actions.moveToElement().actions.perform();
    }
    //(21) Scroll to element and click
    public void scrollWebpageToViewElementAndClick(By by)
    {
        Actions actions = new Actions(driver);
        //driver.findElement(by).actions.moveToElement().actions.perform().Click();
    }
    //(22) Wait for alert to display
    public void waitForAlert(int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().getText();
    }
    //(23) Get attribute of element//get attribute
    public String getAttribute(By by, String text)
    {
        return driver.findElement(by).getAttribute(text);
    }
    //(24) get css property of element //get css value
    public void getCssValue(By by, String text)
    {
        driver.findElement(by).getCssValue(text);
    }
    //(25) it will generate random numbers for email
    public static String randomDate()
    {
        DateFormat format=new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }
    //(26) take screenshot of current display(full)




    //(27) take screenshot of browser
    public static void takeScreenShot(WebDriver webdriver, String fileWithPath) throws IOException
    {
        //convert web driver object to take screen shot
        TakesScreenshot scrShot = ((TakesScreenshot)webdriver);

        //call get screen shot as method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //move image file to new destination
        File DestFile = new File(fileWithPath);

        //copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
    //(28) date stamp short
    public String shortDateStamp()
    {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat();
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }
    //(29) date stamp long
    public String longDateStamp()
    {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat();
        return new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
    }
    //(30) convert date....
    public SimpleDateFormat covertDate()
    {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHMM");
        return new SimpleDateFormat("dd-MMM-yyyy HH:MM");
    }

    //(31) This method determines if an element is enabled or not
    public boolean ifWebElementIsEnabledOrNot(By by)
    {
        return driver.findElement(by).isEnabled();
    }

    //(32) get location false or true
    public boolean getLocation(By by)
    {
        Point location = driver.findElement(by).getLocation();
        return false;
    }
}