package browsersexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxExample {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
        //driver.quit();
    }
}
