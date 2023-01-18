package basicexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameExample {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");


        //driver.switchTo().frame(0);
        //driver.switchTo().frame("mce_0_ifr");
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("I am in Bangalore");

        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//span[text()='File']")).click();
    }
}
