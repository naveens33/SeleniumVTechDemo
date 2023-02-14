package basicexample;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ElementScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/");
        WebElement ele = driver.findElement(By.linkText("Zero Bank"));
        File file1 = ele.getScreenshotAs(OutputType.FILE);
        File destFile=new File("Screenshot12.png");
        FileUtils.copyFile(file1,destFile);
        driver.quit();
    }
}
