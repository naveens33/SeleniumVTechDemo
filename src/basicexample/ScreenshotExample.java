package basicexample;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotExample {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com");
        TakesScreenshot sc = (TakesScreenshot) driver;
        File file1 = sc.getScreenshotAs(OutputType.FILE);
        File destFile=new File("Screenshot1.png");
        FileUtils.copyFile(file1,destFile);
    }
}
