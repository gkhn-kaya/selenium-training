import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample_08 {
    static String theTestPageURL = "https://www.keytorc.com/seleniumTraining/frames";
    static WebDriver driver;

    // Frame içeren web sayfalarında önce frame seçilmeli, onu test ediyoruz.

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                +"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(theTestPageURL);
    }


    @Test
    public void loadTheGreenPage() {
        driver.switchTo().frame(2);
        driver.findElement(By.xpath("//a[@href='green.html']"));
        driver.get(theTestPageURL);
    }

    @Test
    public void reloadThePage(){
        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='index.html']"));
        driver.get(theTestPageURL);
    }

    // satır 27 ve 34 olmadığında; testler ayrı ayrı pass ediyor ama toplu run'da birisi fail birisi pass ediyor.
    // sebebi büyük ihtimalle zaten frame 2'deyken yine aynı frame'i etkinleştirmeye çalışması.
    // çözüm olarak bu satırlara eklenen kod sayfayı yeniden yüklüyor.

    // Hocanın yorumu: normalde browser başlatma "beforeclass" değil "before" olmalı, yani her testte yeni instance
    // kullanılmalı. Benim çözüm doğru, ama get yerine "navigate.back" de kullanılabilir.

}
