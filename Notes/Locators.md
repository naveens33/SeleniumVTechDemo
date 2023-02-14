
## Locators for Selenium
* id - Select element with the specified @id attribute.

* name - Select first element with the specified @name attribute.

* linkText - Select link (anchor tag) element which contains text matching the specified link text

* partialLinkText - Select link (anchor tag) element which contains text matching the specified partial link text

* tag - Tag Name Locate Element using a Tag Name .

* className - Class name Locate Element using a class Name ..

* cssSelector - Select the element using css selectors. You can check here for Css examples and You can also refer W3C CSS Locatros

* xpath - Locate an element using an XPath expression.

### Locating an Element by ID

```WebElement element = driver.findElement(By.id("user_login"));```

### Locating an Element by Name

```WebElement element = driver.findElement(By.name("submit"));```

### Locating an Element by LinkText

```WebElement element = driver.findElement(By.linkText("Pay Bills"))```

### Locating an Element by Partial Link Text

```WebElement element = driver.findElement(By.partialLinkText("Transfer"))```

### Locating an Element by Class Name

```WebElement element = driver.findElement(By.className("alert-item"))```

### Locating an Element by Xpath

```WebElement element = driver.findElement(By.className("alert-item"))```

### Locating an Element by CssSelector

```WebElement element = driver.findElement(By.cssSelector("id#name"))```
