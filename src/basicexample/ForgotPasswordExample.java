package basicexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPasswordExample {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");

        System.out.println(driver.getTitle());
        assert driver.getTitle().equals("Zero - Personal Banking - Loans - Credit Cards"):"Wrong title";

        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.linkText("Forgot your password ?")).click();

        assert driver.getTitle().equals("Zero - Forgotten Password"):"Wrong title";

        driver.findElement(By.name("email")).sendKeys("naveen@gmail.com");
        driver.findElement(By.name("submit")).click();
        
        String text = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div")).getText();
        assert text.contains("Your password will be sent to the following email: naveen.s@gmail.com"):"Wrong Confirmation Message";
    }
}
