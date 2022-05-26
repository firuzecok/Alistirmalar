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

public class Soru4 {

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
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        // 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");


        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
        System.out.println("anaSayfa :" + driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());

        // WebElement anaSayfa=driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        // Assert.assertTrue(anaSayfa.isDisplayed());


        // 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        // Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        WebElement girisYap=driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(girisYap.isDisplayed());


        // Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("hyt@mail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");


        //  'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //  'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement oturum=driver.findElement(By.xpath("//*[text()='Firuze']"));
        Assert.assertTrue(oturum.isDisplayed());

        // Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        // Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        WebElement oturumAcmaSayfasi=driver.findElement(By.xpath("//body[@style='']"));
        Assert.assertTrue(oturumAcmaSayfasi.isDisplayed());




    }
}