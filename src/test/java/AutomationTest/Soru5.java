package AutomationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru5 {

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
        System.out.println("anaSayfa :" + driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());

        // WebElement anaSayfa=driver.findElement(By.xpath("//html[@lang='en']"));
        // Assert.assertTrue(anaSayfa.isDisplayed());


        // 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        // 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        System.out.println("Yeni Kullanici="+driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

        // WebElement yeniKullaniciKaydi = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        // Assert.assertTrue(yeniKullaniciKaydi.isDisplayed());

        // Adı ve kayıtlı e-posta adresini girin
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Firuze");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("hyt@mail.com");

        // 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        Thread.sleep(2000);

        // 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
        System.out.println(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).getText());

        //WebElement hataYazisi=driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        //Assert.assertTrue(hataYazisi.isDisplayed());


        Thread.sleep(2000);

    }
}
