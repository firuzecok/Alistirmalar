package AutomationTest;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru8 extends TestBase {

    @Test
    public void test(){

        // 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        // 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //  Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();

        // Ürün listesi görünür
        driver.findElement(By.xpath("//div[@class='features_items']")).isDisplayed();

        // İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        driver.findElement(By.xpath("(//a[@style='color: brown;'])[1]")).click();

        // Kullanıcı, ürün detay sayfasına yönlendirilir
        driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']")).isDisplayed();

        // Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
        driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Category: Women > Tops']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Rs. 500']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' In Stock']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' New']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' Polo']")).isDisplayed();


    }
}
