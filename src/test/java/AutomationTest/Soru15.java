package AutomationTest;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Soru15 extends TestBase {

    @Test
    public void test(){

      //  1. Tarayıcıyı başlatın
      //  2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

      //  3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

      //  4. 'Kayıt Ol / Giriş Yap' düğmesini tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

      //  5. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        // Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        Actions action=new Actions(driver);
        WebElement yeniKyt=driver.findElement(By.xpath("//input[@name='name']"));
        Faker faker=new Faker();
        action.click(yeniKyt)
                .sendKeys("Zeki")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.ENTER)
                .perform();



        WebElement kayitButonlari=driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
        action.click(kayitButonlari)
                .sendKeys("1234")
                .sendKeys(Keys.TAB).sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("07")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Zeki")
                .sendKeys(Keys.TAB)
                .sendKeys("Gunes")
                .sendKeys(Keys.TAB)
                .sendKeys("Asus")
                .sendKeys(Keys.TAB)
                .sendKeys("Alem sok.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys("Turkiye")
                .sendKeys(Keys.TAB)
                .sendKeys("Edirne")
                .sendKeys(Keys.TAB)
                .sendKeys("452")
                .sendKeys(Keys.TAB)
                .sendKeys("05555555551")
                .sendKeys(Keys.TAB)
                .perform();

        //  6. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        WebElement hesapOlustur=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        hesapOlustur.click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

      //  7. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        WebElement oturumAcld=driver.findElement(By.xpath("//div//li[9]"));
        Assert.assertTrue(oturumAcld.isDisplayed());

        //  8. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

      //  9. 'Sepet' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

      //  10. Sepet sayfasının görüntülendiğini doğrulayın
        WebElement sepetGoruntule=driver.findElement(By.xpath("//tr[@id='product-2']"));
        Assert.assertTrue(sepetGoruntule.isDisplayed());

      //  11. Ödemeye Devam Et'e tıklayın
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

      //  12. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        WebElement adresAyrt=driver.findElement(By.xpath("(//div[@class='container'])[2]"));
        Assert.assertTrue(adresAyrt.isDisplayed());

      //  13. Açıklama metin alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Tam istedigim");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();

      //  14. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        WebElement kartAyrt=driver.findElement(By.xpath("//input[@class='form-control']"));

        //'Öde ve Siparişi Onayla' düğmesine tıklayın
        //  15. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        action.click(kartAyrt).sendKeys("Bank Kart")
                .sendKeys(Keys.TAB)
                .sendKeys("789 456")
                .sendKeys(Keys.TAB)
                .sendKeys("511")
                .sendKeys(Keys.TAB)
                .sendKeys("05")
                .sendKeys(Keys.TAB)
                .sendKeys("2024")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


      //  16. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        WebElement msjDogrula=driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(msjDogrula.isDisplayed());
        System.out.println(msjDogrula.getText());

      //  17. 'Hesabı Sil' düğmesini tıklayın
        //  18. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();


    }
}
