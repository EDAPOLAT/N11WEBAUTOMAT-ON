package methods;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;

public class BaseStep extends BaseTest {

    WebDriverWait webDriverWait= new WebDriverWait(driver,60);
    JavascriptExecutor jsDriver=(JavascriptExecutor) driver;


    public void focusElementJs(By by){

        WebElement webElement = findElement(by);
        scrollElement(webElement);
        focusElement(webElement);
    }

    public void scrollElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void focusElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].focus();", webElement);
    }

    public  void waitVisibilityClick(By by) {
        WebElement webElement=webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webElement.click();
        logger.info("Elementi görüldü ve elemente tıklandı!");
    }

    public  void waitClicableClick(By by) {
        WebElement webElement =webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        webElement.click();
        logger.info("Elementi görüldü ve elemente tıklandı!");

    }

    public void waitVisibilitySendKey(By by, String key) {
        WebElement webElement= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        webElement.sendKeys(key);
        logger.info("'Elementi  görüldü ve  "+key+" değeri girildi!");

    }


    public WebElement findElement(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public  void AssertURL(String URL) {
        Assert.assertEquals(URL, driver.getCurrentUrl());
        logger.info(URL + "Sayfa Açıldı!!");

    }

    public  void waitBySeconds(int seconds) {
        try {
            logger.info(seconds + " Saniye Bekle");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertContainsText(By by,String text){
        Assert.assertTrue(findElement(by).getText().contains(text));
        logger.info("Element değeri ile text değeri ile aynı");
    }


    public void basketPriceControl(By by) {
        if (basketPrice(by) > 0) {
            logger.info(by + "Elementin değeri sıfırdan büyük, sepete ekleme başarılı");
        } else {
            logger.info("Sepete ekleme başarısız");
        }
    }

    public int basketPrice(By by){
        String sepet=findElement(by).getText();
       String amount= getNumericCharacter(sepet);
       System.out.println(amount);
      return Integer.parseInt(amount);

    }
    public String getNumericCharacter(String value) {
        StringBuilder numericCharacter = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            int currentCharacter = value.charAt(i);
            if (currentCharacter >= 48 && currentCharacter <= 57) {
                numericCharacter.append(value.charAt(i));
            }
        }
        return numericCharacter.toString();
    }


    public void productCheck( String expectedValue) {
        String element=driver.findElement(By.xpath("//a[@class='prodDescription']")).getText();
        String actualValue = element;
        mustBeContains(actualValue, expectedValue);
    }

    public void mustBeContains(String actualText, String expectedText) {
        if (!actualText.contains(expectedText)) {
            String assertionMessage = String.format("'%s', '%s' değerini içermiyor!", actualText, expectedText);
            logger.error(assertionMessage);
            Assert.fail(assertionMessage);
        }
        logger.info("'{}', '{}' değerini içeriyor."+actualText+","+expectedText);
    }



}