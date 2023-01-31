package basicexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WorkingWithWindowsExample {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.partialLinkText("privacy")).click();
        String parentWindow = driver.getWindowHandle();

        Set<String> windowhandles =  driver.getWindowHandles();
        for(String windowhandle:windowhandles){
            driver.switchTo().window(windowhandle);
            if(driver.getTitle().equals("Legal Information | Micro Focus")){
                break;
            }
        }
        driver.findElement(By.linkText("Cookie Notice.")).click();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("signin_button")).click();
    }
}
