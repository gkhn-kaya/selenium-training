package Interrogation.FindBy;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdvancedFindBy_05 {
    static String theTestPageURL = "https://www.keytorc.com/seleniumTraining/findByPlayground.php";
    static WebDriver driver;

    //daha kompleks içerik bulma ve doğrulama

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                +"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(theTestPageURL);
    }

    @Test
    public void findByClassName(){
        // match an element's class attribute
        List<WebElement> myList = driver.findElements(By.className("Normal"));
        System.out.println(myList.size());
        System.out.println(myList.get(4).getText());
    }

    @Test
    public void findByLinkText(){
        // look for an <a> in the text (i.e. getText)
        WebElement jumpToPara12 = driver.findElement(By.linkText("jump to para 12"));
        assertEquals("a38", jumpToPara12.getAttribute("id"));
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
