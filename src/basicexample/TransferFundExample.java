package basicexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferFundExample {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        driver.get("http://zero.webappsecurity.com/bank/account-summary.html");

        driver.findElement(By.partialLinkText("Transfer")).click();
        assert driver.getTitle().equals("Zero - Transfer Funds"):"Wrong Page Title";

        WebElement fromAccountElement = driver.findElement(By.xpath("//*[@id=\"tf_fromAccountId\"]"));
        Select fromAccount = new Select(fromAccountElement);
        //fromAccount.selectByIndex(2);
        //fromAccount.selectByValue("5");
        fromAccount.selectByVisibleText("Loan(Avail. balance = $ 780)");

        WebElement toAccountElement = driver.findElement(By.cssSelector("#tf_toAccountId"));
        Select toAccount =  new Select(toAccountElement);
        toAccount.selectByVisibleText("Brokerage(Avail. balance = $ 197)");

        driver.findElement(By.cssSelector("#tf_amount")).sendKeys("500");
        driver.findElement(By.xpath("//*[@id=\"tf_description\"]")).sendKeys("Payment");
        driver.findElement(By.cssSelector("#btn_submit")).click();

        assert !driver.findElement(By.xpath("//*[@id=\"tf_fromAccountId\"]")).isEnabled() : "Wrong! Element is enabled";

        driver.findElement(By.cssSelector("#btn_submit")).click();
        String msg = driver.findElement(By.xpath("//*[@id=\"transfer_funds_content\"]/div/div/div[1]")).getText();
        assert msg.equals("You successfully submitted your transaction."):"Wrong Message";
    }
}
