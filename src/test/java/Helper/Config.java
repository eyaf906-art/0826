
package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Config {

    public static WebDriver driver;


    public static void startBrowser() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        maximizeWindows();
    }


    public static void maximizeWindows() {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }


    public static void stopBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    public static void attente(int secondes) {
        try {
            Thread.sleep(secondes * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    public static void ouvrirNavigateur() {
        startBrowser();
    }

  
    public static void ouvrirNavigateur1() {
        startBrowser();
    }


	}



