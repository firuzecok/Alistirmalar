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

public class Soru6 {
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

        // WebElement anaSayfa=driver.findElement(By.xpath("//html[@lang='en']"));
        // Assert.assertTrue(anaSayfa.isDisplayed());

        // 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-envelope']")).click();

        // GET IN TOUCH'un görünür olduğunu doğrulayın
        WebElement yaziElementi=driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        //  Adı, e-posta adresini, konuyu ve mesajı girin
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Firuze");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hyt@mail.com");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Selenium ile hayat guzel");




        // Dosya yükle
        driver.findElement(By.xpath("//input[@name='upload_file']"));
        //driver.switchTo().alert().accept();


        // 'Gönder' düğmesini tıklayın
       driver.findElement(By.xpath("//input[@name='submit']")).click();
       driver.switchTo().alert().accept();

       // Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed();

        // Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();




    }
}