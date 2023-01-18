package basicexample;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.Duration;

public class PurchaseForiegnCurrencyExample {
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
        //Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        /*
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);
         */
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement currencyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select#pc_currency")));
        Select currency = new Select(currencyElement);
        currency.selectByVisibleText("Denmark (krone)");

        String sellRateFullText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sp_sell_rate"))).getText();
        Double sellRate = Double.parseDouble(sellRateFullText.split(" ")[4]);
        System.out.println(sellRate);

        int amount = 100;
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys(""+amount);

        driver.findElement(By.id("pc_inDollars_false")).click();
        driver.findElement(By.id("pc_calculate_costs")).click();
        String conversionRateFullText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pc_conversion_amount"))).getText();
        Double conversionRate = Double.parseDouble(conversionRateFullText.split(" ")[4]);
        System.out.println(conversionRate);

        System.out.println(sellRate*amount);
        assert sellRate*amount == conversionRate;
    }
}
