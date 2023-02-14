Webdriver does not differentiate between windows and tabs. If you open any new tab or window, both can be handled using window handles. Each window or tab has a unique identifier which remains the same for a session.

* getWindowHandle

getWindowHandle() is a method provided by the WebDriver interface in Selenium. It returns the current window handle as a string. This handle can switch to that specific window or tab using the switchTo().window() method.

* getWindowHandles

getWindowHandles() is a method provided by the WebDriver interface in Selenium. It returns a set of window handles, each representing a unique window or tab. This method can be used to switch between multiple windows or tabs open in the browser.

### Switching windows or tabs 

driver.switchTo().window(windowHandles);

Refer code [click here..](../src/basicexample/WorkingWithWindowsExample.java)