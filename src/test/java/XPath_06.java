package Interrogation.FindBy;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class XPath_06 {
    static String theTestPageURL = "https://www.keytorc.com/seleniumTraining/findByPlayground.php";
    static WebDriver driver;

    //xPath kullanarak element bulmak

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                +"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(theTestPageURL);
    }

    @Test
    public void conditionalAttributes() {
        WebElement element;
        element = driver.findElement(By.xpath("//a[@name='aName26' and @class='normal']"));
        assertEquals("Expected matching id", "a26", element.getAttribute("id"));
    }

    @Test
    public void pathNavigation(){
        WebElement element = driver.findElement(By.xpath("//div[@id='div18']//a[@name='aName26']"));
        assertEquals("Expected matching id", "a26", element.getAttribute("id"));
    }

}
