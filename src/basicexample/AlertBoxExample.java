package basicexample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertBoxExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        driver.get("http://zero.webappsecurity.com/bank/account-summary.html");

        driver.findElement(By.linkText("Pay Bills")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("purchase_cash"))).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        assert alert.getText().equals("Please, ensure that you have filled all the required fields with valid values."): "Wrong Alert message";
        alert.accept();

        //driver.findElement(By.id("pc_calculate_costs")).click();

    }
}
