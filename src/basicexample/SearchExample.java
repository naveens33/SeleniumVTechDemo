package basicexample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchExample {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("searchTerm")).sendKeys("account");
        driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.partialLinkText("Zero - Account "));
        System.out.println(elements.size());
        for(WebElement element: elements){
            System.out.println(element.getText());
        }
    }
}
