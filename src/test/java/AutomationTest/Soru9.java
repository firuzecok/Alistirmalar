package AutomationTest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utilities.TestBase;

public class Soru9 extends TestBase {

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
        //driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='features_items']")).isDisplayed();

        // Arama girişine ürün adını girin ve ara düğmesine tıklayın
        driver.findElement(By.xpath("(//input[@name='search'])")).sendKeys("Winter Top");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //  'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();

        // Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//div[@class='features_items']")).isDisplayed();

    }
}
