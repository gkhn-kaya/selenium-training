import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Synchronization_10 {
    static String theTestPageURL = "http://www.jquery-steps.com/Examples#async";
    static WebDriver driver;

    // bazı durumlarda "loading..." söz konusu ise client tarafının beklemesi gerekli.
    // bu bekleme işlemine synchronization deniliyor.
    // timeout tanımlanıyor.


    @BeforeClass
    public static void setup() throws MalformedURLException{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "//chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test
    public void asyncPageSample(){
        driver.get(theTestPageURL);

        driver.findElement(By.id("init-async")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='example-async-p-0']/p[1]")));

        System.out.print(driver.findElement
                (By.xpath("//*[@id='example-async-p-0']/p[1]")).getText());

    }
}
