import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class WebElementInterrogation_04 {

    // bir web sayfasını açıp elementlerin içeriğini kontrol etmek ve doğrulamak.

    @Test
    public void WebElementInterrogationBasics(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                +"//chromedriver.exe");

        String theTestPageURL = "https://www.keytorc.com/seleniumTraining/basicWebPage.html";
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(theTestPageURL);

        WebElement paragraph1 = driver.findElement(By.id("para1"));
        WebElement paragraph2 = driver.findElement(By.id("para2"));

        assertTrue(paragraph1.getText().contains("First"));
        assertFalse(paragraph1.getText().contains("Third"));

        driver.quit();
    }

}
