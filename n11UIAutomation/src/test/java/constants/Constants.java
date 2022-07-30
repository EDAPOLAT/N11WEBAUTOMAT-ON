package constants;

import org.openqa.selenium.By;

public class Constants {
    public static final By AYDINLATMA_METNI_POPUP = By.xpath("//div/span[@class='btn baseBtn-green' and text()='Tamam']");
    public static final By LOGIN_BUTTON = By.xpath("//a[@class='btnSignIn' and @title='Giriş Yap']");
    public static final By EMAIL = By.id("email");
    public static final String USER_NAME = "tastinium123@gmail.com";
    public static final By PASSWORD = By.id("password");
    public static final String MY_PASSWORD = "Aa123456";
    public static final By SUBMIT_BUTTON = By.id("loginButton");
    public static final By MY_ACCOUNT = By.xpath("//div/a[@title=\"Hesabım\"]");
    public static final By SEARCH = By.id("searchData");
    public static final String SEARCH_WORD = "Telefon";
    public static final By SEARCH_BUTTON = By.xpath("//a[@class='searchBtn' and @title='ARA']");
    public static final By PAGE_NUMBER = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[2]/a[2]");
    public static final By ADD_BASKET = By.xpath("//button[@title=\"Sepete Ekle\"]");
    public static final By ITEM_LIST = By.xpath("//div[@id='view']//ul//li");
    public static final By BASKET_TITLE = By.xpath("//div[@class='myBasketHolder']/a");
    public static final By POP_PUP = By.xpath("//span[@class='btn btnBlack' and text()='Tamam']");
    public static final By AMOUNT = By.xpath("(//span[@class='price'])[5]");
    public static final By DELETE_FROM_CART = By.xpath("//span[@title='Sil']");
    public static final By DELETE_BUTTON = By.id("deleteBtnDFLB");

}
