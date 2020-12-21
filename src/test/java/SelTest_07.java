import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class SelTest_07 {
    static String theTestPageURL = "https://www.keytorc.com/seleniumTraining/basicHtmlForm.html";
    static WebDriver driver;

    // user ve pass ile login olduktan sonra gösterilen değerlerin verifikasyonu.

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                +"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(theTestPageURL);
    }

    @Test
    public void fillLoginInfo(){
        //ilk yöntemde değişken atamadan işlem yapılıyor ve ismi username olan yere gokkaya yazılıyor.
        driver.findElement(By.name("username")).sendKeys("gokkaya");

        //ikinci yöntemde element için değişken atanıyor, bu sayede ileride kullanılabilir. sonrasında değişkene 123456 yazılıyor.
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456");

        //name ile submitbutton yazarsan aynı name'e sahip iki button var. cancel'e basıp sonlanıyor. o yüzden value submit olmalı.
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.id("_valueusername")).getText().equals("gokkaya"));

        // verifikasyon yaparken küçük büyük harf duyarsız olması için:
        // Assert.assertTrue(driver.findElement(By.id("_valueusername")).getText().toLowerCase(Locale.ROOT).equals("gokkaya"));
    }

}
