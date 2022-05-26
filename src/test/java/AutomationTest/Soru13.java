package AutomationTest;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Soru13 extends TestBase {

    @Test
    public void test(){

        // 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        Actions actions=new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        // Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'yi tıklayın
        WebElement hrHngUrun=driver.findElement(By.xpath("(//div[@class='choose'])[5]"));
        hrHngUrun.click();

        // Ürün detayının açıldığını doğrulayın
        driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed();

        // Miktarı 4'e yükseltin
        WebElement miktarButonu=driver.findElement(By.xpath("//input[@name='quantity']"));
        miktarButonu.click();
        miktarButonu.sendKeys(Keys.BACK_SPACE);
        miktarButonu.sendKeys("4");

        // 'Sepete ekle' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@type='button']")).click();

        // Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

        //  Ürünün sepet sayfasında tam miktarıyla görüntülendiğini doğrulayın
        WebElement urunGoruntule=driver.findElement(By.xpath("//tr[@id='product-5']"));
        Assert.assertTrue(urunGoruntule.isDisplayed());




    }
}
