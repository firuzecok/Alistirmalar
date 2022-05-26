package Alistirmalar;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import Utilities.TestBase;

import java.util.ArrayList;

import java.util.List;

public class AmazonTest extends TestBase {
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
        String urunn=urun.getText();

        // Click iPhone13 at the top of the list
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();


        // Log the following values for each size

        WebElement size=driver.findElement(By.xpath("(//span[@class='selection'])[1]"));
        String sizee=size.getText();

        WebElement renk=driver.findElement(By.xpath("(//span[@class='selection'])[2]"));
        String renkk=renk.getText();

        WebElement urunFiyati=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[6]"));
        String urunFiyatii=urunFiyati.getText();

        WebElement stokDurumu=driver.findElement(By.xpath("(//div[@class='celwidget'])[38]"));
        String stokk=stokDurumu.getText();

        List<String>ozellikler=new ArrayList<>();
        ozellikler.add(urunn);
        ozellikler.add(sizee);
        ozellikler.add(renkk);
        ozellikler.add(urunFiyatii);
        ozellikler.add(stokk);


        for (int i = 0; i <ozellikler.size() ; i++) {
        }
            System.out.println(ozellikler.get(0) +" "+"Size :"+ ozellikler.get(1));
            System.out.println("Color :"+ ozellikler.get(2)+"  "+"Price :"+  ozellikler.get(3)+"TL");
            System.out.println("Stock :" +ozellikler.get(4));



    }
}
