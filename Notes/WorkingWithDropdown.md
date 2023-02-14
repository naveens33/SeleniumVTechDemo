WebDriver’s support classes called “Select”, which provides useful methods for interacting with select options. User can perform operations on a select dropdown and also de-select operation using the below methods.

## Select Methods

### 1. selectByVisibleText(String arg0)
This method is used to select one of the options in a drop-down box or an option among multiple selection boxes. It takes a parameter of String which is one of the values of Select element and it returns nothing.

``` 
WebElement fromAccountElement = driver.findElement(By.xpath("//*[@id=\"tf_fromAccountId\"]"));
Select fromAccount = new Select(fromAccountElement);
fromAccount.selectByVisibleText("Loan(Avail. balance = $ 780)");
```

### 2. selectByIndex(int arg0) 
This method is similar to ‘selectByVisibleText’, but the difference here is that the user has to provide the index number for the option rather than text. It takes the integer parameter which is the index value of Select element and it returns nothing.

``` 
WebElement fromAccountElement = driver.findElement(By.xpath("//*[@id=\"tf_fromAccountId\"]"));
Select fromAccount = new Select(fromAccountElement);
fromAccount.selectByIndex(2);
```
### 3. selectByValue(String arg0)
This method asks for the value of the desired option rather than the option text or an index. It takes a String parameter which is one of the values of Select element and it does not return anything.

``` 
WebElement fromAccountElement = driver.findElement(By.xpath("//*[@id=\"tf_fromAccountId\"]"));
Select fromAccount = new Select(fromAccountElement);
fromAccount.selectByValue("5");
```

Refer code [click here..](../src/basicexample/TransferFundExample.java)