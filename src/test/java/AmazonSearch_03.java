import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class AmazonSearch_03 {

    // ikinci günün ilk denemesi
    // amazon'u açıp arama kutusuna metin girme ve arama yapma

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void openBrowser() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                +"//chromedriver.exe");

        //driver = new ChromeDriver();

    }

    @Test
    public void testAmazonWebSiteOnChromeDriver() {
        driver.navigate().to("http://www.amazon.com");
        WebElement e = driver.findElement(By.id("twotabsearchtextbox"));
        e.sendKeys("Samsung S10");
        driver.findElement(By.xpath("//input[@value='Go']")).click();
    }

    @AfterEach
    public void closeBrowser() {driver.quit();}

}
