package AutomationTest;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Soru11 extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        // 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());


        // 'Sepet' düğmesini tıklayın

        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[1]")).click();


        // Altbilgiye ilerleyin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        // 'ABONELİK' metnini doğrulayın
        driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed();

        // Girişe e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("hyt@mail.com"+Keys.ENTER);

        Thread.sleep(5000);


        // Başarı mesajını doğrulayın 'Başarıyla abone oldunuz!' görünür

        driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed();




      /*

 */
    }
}
