package basicexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidSelectorExceptionExample {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");

        //driver.findElement(By.className("headers")).click();

        //InvalidSelectorException
        //driver.findElement(By.className("signin btn btn-info")).click();

        //NoSuchElementException
        driver.findElement(By.id("signin_")).click();

    }
}
