JavaScriptExecutor is an interface that is used to execute JavaScriprt through selenium webdriver. JavaScript is a programming language that interacts with HTML in a browser, and to use this function in Selenium, JavascriptExecutor is required.

Example1 (Js click)
```
JavascriptExecutor executor = (JavascriptExecutor) driver;
executor.executeScript("arguments[0].click();",ok);
```

Example1 (Highlight a element)
```
JavascriptExecutor executor = (JavascriptExecutor) driver;
executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');",element);
```

Refer code [click here..](../src/basicexample/JsClickExample.java)
Refer code [click here..](../src/basicexample/HighlightElementExample.java)