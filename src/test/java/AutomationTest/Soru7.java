package AutomationTest;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru7 extends TestBase {

@Test
    public void test01(){


    // 'http://automationexercise.com' url'sine gidin
    driver.get("http://automationexercise.com");

    // Ana sayfanın başarıyla görünür olduğunu doğrulayın
    WebElement anaSayfa=driver.findElement(By.xpath("//html[@lang='en']"));
    Assert.assertTrue(anaSayfa.isDisplayed());

    // Test Vakaları' düğmesine tıklayın
    driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]")).click();

    //  Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
    driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();

}


}
