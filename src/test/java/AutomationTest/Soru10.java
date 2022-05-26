package AutomationTest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Utilities.TestBase;

public class Soru10 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        // 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        // Altbilgiye ilerleyin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.SHIFT.END).perform();
        Thread.sleep(3000);

        // ABONELİK' metnini doğrulayın
        driver.findElement(By.xpath("(//h2)[82]")).isDisplayed();

        // Girişe e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("hyt@mail.com"+Keys.ENTER);

        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        Thread.sleep(3000);

        // Başarı mesajını doğrulayın 'Başarıyla abone oldunuz!' görünür

        driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']")).isDisplayed();


    }
}
