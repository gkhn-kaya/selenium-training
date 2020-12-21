import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class WindowExample_09 {

    // Her tab için bir key vardır. yeni tab açmadan, eski tabı kaydetmek gerekir ki yeni tabın
    // hangisi olduğunu tespit edebilelim. her yeni tab açışta eski anahtarlar "oldkey" şeklinde
    // kaydedilmelidir ki, son durumda tab listesi çağırıldığında yeni tab için key tespit edilebilsin.


    @Test
    public void switchToNewWindow() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.keytorc.com/seleniumTraining/frames/");

        String existingHandle = driver.getWindowHandle();

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='http://www.keytorc.com']")).click();

        Thread.sleep(1000);

        Set<String> myWindows = driver.getWindowHandles();
        String newWindowHandle = "";

        for (String aHandle : myWindows) {
            if (!existingHandle.contentEquals(aHandle)) {
                newWindowHandle = aHandle;
                break;
            }
        }
        driver.switchTo().window(newWindowHandle);

        Thread.sleep(5000);

        assertTrue("Expected Keytorc Site Title",
                driver.getTitle().contains("Test Hizmetleri"));

        driver.switchTo().window(existingHandle);
    }
}
