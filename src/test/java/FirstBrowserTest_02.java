import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstBrowserTest_02 {

    //tarayıcıyı aç, google adresine git, titlebar kontrol et ve tarayıcıyı kapat

    @Test
    public void BrowserTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                +"//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com.tr");
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }
}
