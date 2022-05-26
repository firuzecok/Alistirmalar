package AutomationTest;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Soru14 extends TestBase {

    @Test
    public void test() {

        // 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        // Sepete ürün ekleyin
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();

        //Sepet' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

        // Sepet sayfasının görüntülendiğini doğrulayın
        WebElement sepetGoruntule=driver.findElement(By.xpath("//tr[@id='product-2']"));
        Assert.assertTrue(sepetGoruntule.isDisplayed());

        // Ödemeye Devam Et'e tıklayın
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        // 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();

        // Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        Actions action=new Actions(driver);
        WebElement yeniKyt=driver.findElement(By.xpath("//input[@name='name']"));
        Faker faker=new Faker();
        action.click(yeniKyt)
                .sendKeys("Zuleyha")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.ENTER)
                .perform();



      WebElement kayitButonlari=driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
      action.click(kayitButonlari)
              .sendKeys("1234")
              .sendKeys(Keys.TAB).sendKeys("10")
              .sendKeys(Keys.TAB)
              .sendKeys("03")
              .sendKeys(Keys.TAB)
              .sendKeys("1993")
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys("zlyh")
              .sendKeys(Keys.TAB)
              .sendKeys("Apak")
              .sendKeys(Keys.TAB)
              .sendKeys("Volvo")
              .sendKeys(Keys.TAB)
              .sendKeys("java sok.")
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.PAGE_DOWN)
              .sendKeys(Keys.TAB)
              .sendKeys("Kanberra")
              .sendKeys(Keys.TAB)
              .sendKeys("Sydney")
              .sendKeys(Keys.TAB)
              .sendKeys("456")
              .sendKeys(Keys.TAB)
              .sendKeys("05555555555")
              .sendKeys(Keys.TAB)
              .perform();


      // 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        WebElement hesapOlustur=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        hesapOlustur.click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //  En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        WebElement oturumAcld=driver.findElement(By.xpath("//div//li[9]"));
        Assert.assertTrue(oturumAcld.isDisplayed());

        // 'Sepet' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        // 'Ödemeye Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        // Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        WebElement adresAyrt=driver.findElement(By.xpath("(//div[@class='container'])[2]"));
        Assert.assertTrue(adresAyrt.isDisplayed());


        // Açıklama metin alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Siparis");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();

        // Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        WebElement kartAyrt=driver.findElement(By.xpath("//input[@class='form-control']"));

        //'Öde ve Siparişi Onayla' düğmesine tıklayın
        action.click(kartAyrt).sendKeys("Bank Kart")
                .sendKeys(Keys.TAB)
                .sendKeys("1234 456")
                .sendKeys(Keys.TAB)
                .sendKeys("411")
                .sendKeys(Keys.TAB)
                .sendKeys("01")
                .sendKeys(Keys.TAB)
                .sendKeys("2023")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //  Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        WebElement msjDogrula=driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(msjDogrula.isDisplayed());
        System.out.println(msjDogrula.getText());

        // 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();


    }
}
