package Alistirmalar;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ulilities.TestBase;

public class C01 extends TestBase {
      /*
          Notes: It may also be necessary to write code to accept the accept cookies warning.
          1. Go to 'https://www.amazon.com.tr/'
          2. Search iPhone13 512
          3. Check that the results are listed
          4. Click iPhone13 at the top of the list
          5. Log the following values for each size
          .Size information .Price .Color .Stock status
      */

    @Test
    public void test01(){
        // Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");

        // Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512"+ Keys.ENTER);

       driver.findElement(By.xpath("//input[@name='accept']")).click();

        // Check that the results are listed
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());

        WebElement urun=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        System.out.println(urun.getText());

        // Click iPhone13 at the top of the list
        driver.findElement(By.xpath("(//img[@class='s-image'])[2]")).click();


        // Log the following values for each size

        WebElement size=driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[2]"));
        System.out.println("Size :"+size.getText());
        WebElement renk=driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[1]"));
        System.out.println("Color :"+renk.getText());
        WebElement urunFiyati=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[6]"));
        System.out.println("Price :"+urunFiyati.getText());
        WebElement stokDurumu=driver.findElement(By.xpath("(//div[@class='celwidget'])[38]"));
        System.out.println("Stock :"+stokDurumu.getText());


    }
}
