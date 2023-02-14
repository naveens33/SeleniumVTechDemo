When working with automated tests using Selenium, we often need to take a screenshot of a web page or part of a web page. This can be useful, particularly when debugging test failures or verifying our application behavior is consistent across different browsers. We can take screenshots at runtime using the test script that helps us bug analysis by viewing the state of the application at the time of failure.

### 1. Current Webpage

```
TakesScreenshot sc = (TakesScreenshot) driver;
File file1 = sc.getScreenshotAs(OutputType.FILE);
File destFile=new File("screenshot.png");
FileUtils.copyFile(file1,destFile);
```

Refer code [click here..](../src/basicexample/ScreenshotExample.java)

### 2. Full Screenshot

AShot() is a webdriver screenshot utility to capture entire page screenshot and is natively supported from Selenium 3 onwards.

```
Screenshot screenshot=new AShot()
        .shootingStrategy(ShootingStrategies.viewportPasting(1000))
        .takeScreenshot(driver);
ImageIO.write(screenshot.getImage(),
        "PNG",new File("screenshot.png"));        
```

Refer code [click here..](../src/basicexample/FullPageScreenshot.java)

### 3. WebElement Screenshot

```
WebElement ele = driver.findElement(By.linkText("Zero Bank"));
TakesScreenshot sc = (TakesScreenshot) ele;
File file1 = sc.getScreenshotAs(OutputType.FILE);
File destFile=new File("Screenshot12.png");
FileUtils.copyFile(file1,destFile);
```

Refer code [click here..](../src/basicexample/ElementScreenshot.java)
