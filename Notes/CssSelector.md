A CSS Selector is a combination of an element selector and a value which identifies the web element within a web page.  They are string representations of HTML tags, attributes, Id and Class.  As such they are patterns that match against elements in a tree and are one of several technologies that can be uses to select nodes in an XML document.

## Simple

### Direct Child

A direct child in XPATH is defined by the use of a “/“, while on CSS, it’s defined using “>”

> Examples:

```
XPath: //div/a
```

```
CSS: div > a
```

### Child or Subchild

If an element could be inside another or one it’s childs, it’s defined in XPATH using “//” and in CSS just by a whitespace.

> Examples:

```
XPath: //div//a
```

```
CSS: div a
```

### Id

An element’s id in XPATH is defined using: “[@id='example']” and in CSS using: “#” - ID's must be unique within the DOM.

> Examples:

```
XPath: //div[@id='example']
```

```
CSS: #example
```

### Class

For classes, things are pretty similar in XPATH: “[@class='example']” while in CSS it’s just “.”

> Examples:

```
XPath: //div[@class='example']
```

```
CSS: .example
```

## Advanced

### Next Sibling

This is useful for navigating lists of elements, such as forms or ul items. The next sibling will tell selenium to find the next adjacent element on the page that’s inside the same parent. Let’s show an example using a form to select the field after username.

> Example:

```
XPATH: //input[@id='username']/following-sibling::input[1]
```

```
CSS: #username + input
```

## Attribute Values

If you don’t care about the ordering of child elements, you can use an attribute selector in selenium to choose elements based on any attribute value. A good example would be choosing the ‘username’ element of the form above without adding a class.

We can easily select the username element without adding a class or an id to the element.

> Examples:

```
XPATH: //input[@name='username']
```

```
CSS: input[name='username']
```

We can even chain filters to be more specific with our selectors.

```
XPATH: //input[@name='login'and @type='submit']
```

```
CSS: input[name='login'][type='submit'] 
```

Here Selenium will act on the input field with name="login" and type="submit"

### Sub-String Matches

CSS in Selenium has an interesting feature of allowing partial string matches using ^=, $=, or *=. I’ll define them, then show an example of each:

> Examples:

^= Match a prefix

```
CSS: a[id^='id_prefix_']
```

A link with an “id” that starts with the text “id_prefix_”

$= Match a suffix

```
CSS: a[id$='_id_sufix']
```

A link with an “id” that ends with the text “_id_sufix”

*= Match a substring

```
CSS: a[id*='id_pattern']
```

A link with an “id” that contains the text “id_pattern”

### Matching By Inner Text -- This is Deprecated (No more available)

And last, one of the more useful pseudo-classes, :contains() will match elements with the desired text block:

> Examples:

```
CSS: a:contains('Log Out')
```

## Q&A:

### Is there a CSS equivalent for selecting text nodes (as with XPath’s text())

No, it’s not possible to do the same with CSS. CSS selectors only work on elements, not on the text nodes they contain. There used to be a :contains() pseudo-class for this in a CSS 3 draft, but the current CSS3 spec has removed it.

### Which is better cssSelector or Xpath and why ?

CSS selectors perform far better than Xpath and it is well documented in Selenium community. Here are some reasons,

* Xpath engines are different in each browser, hence make them inconsistent
* IE does not have a native xpath engine, therefore selenium injects its own xpath engine for compatibility of its API. Hence we lose the advantage of using native browser features that WebDriver inherently promotes.

However there are some situations where, you need to use xpath, for example, searching for a parent element or searching element by its text (I wouldn't recommend the later).

> Refer [What is the difference between cssSelector & Xpath and which is better with respect to performance for cross browser testing? - stack overflow](https://stackoverflow.com/questions/16788310/what-is-the-difference-between-cssselector-xpath-and-which-is-better-with-resp)

