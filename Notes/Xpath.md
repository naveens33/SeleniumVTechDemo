XPath is defined as XML path. It is a syntax or language for finding any element on the web page using XML path expression. XPath is used to find the location of any element on a webpage using HTML DOM structure.

## Types of X-path

### Absolute XPath

* It is a direct way to locate an element.
* It is very brittle(hard but liable to break easily).
* Starts with single slash “/” that means starting to search from the root.

```
/html/body/div[1]/p/div[2]/div/div[2]/div/div/h2[1]
```

### Relative XPath

* Starts from the middle of the HTML DOM.
* Starts with a double slash “//” that means it can start to search anywhere in the DOM structure.
* Shorter than Absolute XPath.

```
//input[@id='searchTerm']
```

## Basic XPath

* //elementname[@attributename='value']

```
//select[@id='tf_fromAccountId']
```

* //*[@attributename='value']

  (*) - any element which match this condition

```
//*[@id='tf_fromAccountId']
```

## contains()

Contains() is a method used in XPath expression. It is used when the value of any attribute changes dynamically and it partially compare the value

* //elementname[contains(@attribute,'value')]

  id='tf_account_12343843578457549545897354789123'

```
//input[contains(@id,'tf_account_')]
```

## starts-with()

* //elementname[starts-with(@attribute,'value')]

This method checks the starting text of an attribute. It is very handy to use when the attribute value changes dynamically but also you can use this method for non-changing attribute values.

```
//input[starts-with(@id,'tf_account_')]
```

## text()

We can find an element with its exact text.

* //elementname[text()='value')]

* //elementname[contains(text(),'value')]

```
//a[starts-with(text(),'My')]
```

```
//a[text()="Savings"]
```

## Child

Selects children elements of the current node

* //parent[]/child[]/child[]/child[]

```
//a[@id='sp_get_payee_details']/i
```

## Locate an Element inside Array of Elements

```
(//a[text()='Savings'])[2]
```

## or & and

In or expression, two conditions are used, whether 1st condition OR 2nd condition should be true. It is also applicable if any one condition is true or maybe both. Means any one condition should be true to find the element.

```
//a[text()='Savings' or contains(@href,'accountId=3')]
```

In and expression, two conditions are used, both conditions should be true to find the element. It fails to find element if any one condition is false.

```
//a[text()='Savings' and contains(@href,'accountId=3')]
```
## XPath Relationship
* Parent
* Child
* Siblings
* Ancestor
* Descendants

## XPath Axes
|AxisName	|Result|
|---------------|------|
|ancestor	|Selects all ancestors (parent, grandparent, etc.) of the current node|
|ancestor-or-self|	Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself|
|child	|Selects all children of the current node|
|descendant	|Selects all descendants (children, grandchildren, etc.) of the current node|
|descendant-or-self	|Selects all descendants (children, grandchildren, etc.) of the current node and the current node itself
|following	|Selects everything in the document after the closing tag of the current node
|following-sibling	|Selects all siblings after the current node|
|parent	|Selects the parent of the current node|
|preceding	|Selects all nodes that appear before the current node in the document, except ancestors node|
|preceding-sibling	|Selects all siblings before the current node|

## Q&A:

### Why Xpath “ends-with()” does not work ?

The ends-with function is part of xpath 2.0 but browsers generally only support xpath 1.0.

### What is the error in below statement

```
//a[text()='Savings' OR contains(@href,'accountId=3')]
```

“or” is case-sensitive, we should not use capital “OR”. So, above statement wont work

similarly “and” also case-sensitive
