package AutomationTest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Utilities.TestBase;

public class Soru12 extends TestBase {
    @Test
    public void test() {

        // 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        // 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        // İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='product-overlay'])[1]"));
        actions.moveToElement(ilkUrun).perform();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();


        // 'Alışverişe Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();


        // İkinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        WebElement ikinciUrun=driver.findElement(By.xpath("(//div[@class='product-overlay'])[2]"));
        actions.moveToElement(ikinciUrun).perform();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();


        // Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        // Her iki ürünün de Sepete eklendiğini doğrulayın
        WebElement sepetEkMi=driver.findElement(By.xpath("//div[@id='cart_info']"));
        sepetEkMi.isDisplayed();
        actions.sendKeys(Keys.PAGE_DOWN).perform();



        // Fiyatlarını, miktarını ve toplam fiyatını doğrulayın

        WebElement ilkUrunFiyat=driver.findElement(By.xpath("(//*[text()='Rs. 500'])[1]"));
        WebElement ikinciUrunFiyat=driver.findElement(By.xpath("(//*[text()='Rs. 400'])[1]"));
        WebElement ilkUrunAded=driver.findElement(By.xpath("(//button[@class='disabled'])[1]"));
        WebElement ikinciUrunAded=driver.findElement(By.xpath("(//button[@class='disabled'])[2]"));
        WebElement ilkUrunTplFiyat=driver.findElement(By.xpath("(//*[text()='Rs. 500'])[2]"));
        WebElement ikinciUrunTplFiyat=driver.findElement(By.xpath("(//*[text()='Rs. 400'])[2]"));
        Assert.assertTrue(ilkUrunFiyat.isEnabled());
        Assert.assertTrue(ilkUrunAded.isEnabled());
        Assert.assertTrue(ilkUrunTplFiyat.isEnabled());
        Assert.assertTrue(ikinciUrunFiyat.isEnabled());
        Assert.assertTrue(ikinciUrunAded.isEnabled());
        Assert.assertTrue(ikinciUrunTplFiyat.isEnabled());



    }
}
