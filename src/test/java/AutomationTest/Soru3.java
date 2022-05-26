package AutomationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru3 {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        // 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");


        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
         WebElement anaSayfa=driver.findElement(By.xpath("//html[@lang='en']"));
         Assert.assertTrue(anaSayfa.isDisplayed());


        // 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        // Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        WebElement girisYap = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(girisYap.isDisplayed());

        // Yanlış e-posta adresi ve şifre girin
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("java@mail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1251");
        Thread.sleep(1000);

        // Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // -postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        WebElement hata=driver.findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(hata.isDisplayed());


    }
}