package step;
import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class  MainClass extends BaseTest {

    StepImplementation stepImplementation;

    @BeforeTest
    public void beforeTest(){
        stepImplementation = new StepImplementation();
    }


    @Test
    public void testRun() {
        stepImplementation.login();
        stepImplementation.searchAndSelectProduct();
        stepImplementation.addBasket();
        stepImplementation.goBasket();
        stepImplementation.basketPriceCheck();
        stepImplementation.addedproductCheck();
        stepImplementation.deleteFromCart();
        stepImplementation.emptyBasketCheck();

    }
}
