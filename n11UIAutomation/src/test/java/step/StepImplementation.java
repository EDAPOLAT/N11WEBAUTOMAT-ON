package step;

import methods.BaseStep;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

import static constants.Constants.*;

public class StepImplementation extends BaseStep{

    public static Logger logger = Logger.getLogger(StepImplementation.class);
    private static String PRODUCT_NAME;

    public  void login() {
         waitClicableClick(AYDINLATMA_METNI_POPUP);
         waitClicableClick(LOGIN_BUTTON);
         waitVisibilitySendKey(EMAIL, USER_NAME);
         waitVisibilitySendKey(PASSWORD, MY_PASSWORD);
         waitBySeconds(2);
         waitClicableClick(SUBMIT_BUTTON);
         logger.info("Login işlemi başarılı!");

    }

    public  void searchAndSelectProduct() {
        waitVisibilitySendKey(SEARCH,SEARCH_WORD);
        waitVisibilityClick(SEARCH_BUTTON);
        focusElementJs(PAGE_NUMBER);
        waitVisibilityClick(PAGE_NUMBER);
        AssertURL("https://www.n11.com/arama?q=Telefon&pg=2");
        List<WebElement> links = driver.findElements(ITEM_LIST);
        System.out.println("boyutu : " + links.size());
        Random productSize = new Random();
        int randomNumber = productSize.nextInt(links.size());
        System.out.println("Random üretilen Sayı:" + randomNumber);
        waitClicableClick(By.xpath("(//li[@class='column '])[ "+ randomNumber + "]"));

    }

    public   void addBasket() {
         String element=driver.findElement(By.xpath("//h1[@class='proName']")).getText();
         PRODUCT_NAME=element;
         waitClicableClick(ADD_BASKET);
         waitBySeconds(4);

    }

    public   void goBasket() {
        waitVisibilityClick(BASKET_TITLE);
        waitVisibilityClick(POP_PUP);

    }

    public   void addedproductCheck( ) {
        productCheck(PRODUCT_NAME);
    }

    public   void basketPriceCheck() {
        basketPriceControl(AMOUNT);
    }

    public void deleteFromCart(){
        waitVisibilityClick(DELETE_FROM_CART);
        waitVisibilityClick(DELETE_BUTTON);

    }

    public void emptyBasketCheck(){
        assertContainsText(DELETE_BUTTON,"Sepetin Boş Görünüyor");
    }

}
