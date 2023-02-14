Synchronization has a very vital role to play in automation. Code execution and application need to be in sync to perform the operation. If the application slows down for any reasons like network, heavy load, etc  then the code keeps on checking for the particular web element. If the code doesn't able to find that element it fails, by throwing exceptions like NoSuchElement, ElementNotVisible, etc.

Synchronization can be achieved by 2 ways:

* Unconditional
* Conditional

## Unconditional
This concept of synchronization comes from Java language where we just specify the timeout limit. It pauses the code for particular time specified and then it starts to execute the next line of code.
```
Thread.sleep();
```

## Conditional
In conditional synchronization, conditions will be set along with the timeout limit. Code will wait for the specified time declared until the expected condition gets satisfied, then it executes the next line of code.

Conditional synchronization can be achieved by 3 ways:

* Implicit wait
* Explicit wait
* Fluent wait

### Implicit wait 
Implicit Wait tells the WebDriver to Wait until the stated time before throwing the NoSuchElement/ElementNotVisible exception. Waiting time across the test script between each consecutive steps are taken by default. Hence, next testStep will execute only when the specified time is elapsed post executing the previous testStep.
```
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
```

### Explicit wait
Explicit waits are very good to use when page loads dynamically. Explicit Wait tells the WebDriver to Wait until the specified condition is met or maximum time elapses before throwing NoSuchElement (or) ElementNotVisible Exceptions. Explicit waits are applied for the specified testStep in test script.
```
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
WebElement currencyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select#pc_currency")));        
```

### Fluent wait
FluentWait can define the maximum amount of time to wait for a specific condition and frequency with which to check the condition before throwing an “ElementNotVisibleException” exception.

To say in effortless manner, it tries to find the web element repeatedly at regular intervals of time until the timeout or till the object gets found.

```
  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);
  WebElement currencyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select#pc_currency")));
```

### Difference between Implicit and Explicit Wait
|Implicit Wait|	Explicit Wait|
|-------------|--------------|
|Applies to all elements in a test script.| 	Applies only to specific elements as intended by the user.|
|No need to specify “ExpectedConditions” on the element to be located|	Must always specify “ExpectedConditions” on the element to be located|
|Most effective when used in a test case in which the elements are located with the time frame specified in implicit wait|	Most effective when used when the elements are taking a long time to load. Also useful for verifying property of the element, such as visibilityOfElementLocated, elementToBeClickable, elementToBeSelected|

Refer code [click here..](../src/basicexample/PurchaseForiegnCurrencyExample.java)