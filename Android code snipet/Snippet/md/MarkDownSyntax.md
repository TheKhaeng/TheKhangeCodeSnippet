ctrl + shift + M ==> start .md preview

# This is an Headings

## This is an H2

### This is an H3

#### This is an H4

##### This is an H5

###### This is an H6

--------------------------------------------------------------------------------

# Paragraph

Paragraphs are separated by empty lines. Within a paragraph it's possible to have a line break, simply press

<return> for a new line.</return>

For example, like this.

--------------------------------------------------------------------------------

# Character styles

_Italic characters_

**bold characters**

~~strikethrough text~~

--------------------------------------------------------------------------------

# Character styles

- Item 1
- Item 2
- Item 3

  - Item 3a
  - Item 3b
  - Item 3c

# Ordered list

1. Step 1
2. Step 2
3. Step 3

  1. Step 3.1
  2. Step 3.2
  3. Step 3.3

--------------------------------------------------------------------------------

# Quotes or citations

Introducing my quote:

> Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...

--------------------------------------------------------------------------------

# Code

Use the backtick to refer to a `function()`.

There is a literal ``backtick (`)`` here.

```
This is a code block
```

To add syntax highlighting to a code block, add the name of the language immediately after the backticks:

```javascript
var oldUnload = window.onbeforeunload;
window.onbeforeunload = function() {
    saveCoverage();
    if (oldUnload) {
        return oldUnload.apply(this, arguments);
    }
};
```

--------------------------------------------------------------------------------

# Link

This is [an example](http://www.example.com/) inline link.

[This link](http://example.com/ "Title") has a title attribute.

Links are also auto-detected in text: <http://example.com/>

--------------------------------------------------------------------------------

# Image

![Alt text](/path/to/image.jpg)

![Alt text](/path/to/image.png "Optional title attribute")

![Alt text](/url/to/image.jpg)

<--Collected image definitions-->

--------------------------------------------------------------------------------

# Table

Day     | Meal    | Price
------- | ------- | -----
Monday  | pasta   | $6
Tuesday | chicken | $8
