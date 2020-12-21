import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.Set;

import static java.lang.Thread.sleep;

public class FinalExercise_12 {
    static String theTestPageURL = "http://www.n11.com/giris-yap";
    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                +"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(theTestPageURL);
    }

    @Test
    public void finalExercise() throws InterruptedException {

        // Facebook login ayrı bir pencerede açıldığı için önce Window Handle alınmalı

        String existingHandle = driver.getWindowHandle();

        // Facebook login butonuna tıkla

        driver.findElement(By.xpath("//div[@class='facebook_large medium facebookBtn  btnLogin']")).click();

        Thread.sleep(1000);

        Set<String> myWindows = driver.getWindowHandles();
        String newWindowHandle = "";

        for (String aHandle : myWindows) {
            if (!existingHandle.contentEquals(aHandle)) {
                newWindowHandle = aHandle;
                break;
            }
        }

        // Çıkan yeni pencereye focuslan

        driver.switchTo().window(newWindowHandle);

        Thread.sleep(3000);

        // Login bilgilerini gir (Facebook testuser)

        driver.findElement(By.name("email")).sendKeys("gjfdgpr_changescu_1608280398@tfbnw.net");
        driver.findElement(By.name("pass")).sendKeys("t1hlc1ks23f2");
        driver.findElement(By.xpath("//label[@id='loginbutton']")).click();

        // Facebook Testuser ile login olunamıyor hatasını al ve pencereyi kapat

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='_zpn fcw']")).getText().equals("Hata"));
        driver.close();
        driver.switchTo().window(existingHandle);

        // Normal N11 kullanıcısı olarak oturum aç

        driver.navigate().refresh();

        driver.findElement(By.name("email")).sendKeys("abc@xyz.org");
        driver.findElement(By.name("password")).sendKeys("123456");

        driver.findElement(By.id("loginButton")).click();

        // Son durumda: N11 kullanıcı adı ve şifre doğru olmasına rağmen login kabul etmiyor.
        // Otomasyon olduğunu bir şekilde anlıyor olabilir. Test başka web sitesi ile yapılabilir.
        // Facebook test user silindi. Yeniden oluşturmak için: https://www.facebook.com/whitehat/accounts
        // N11 kullanıcı adı ve şifre rastgele olarak değiştirildi.

        }


}
