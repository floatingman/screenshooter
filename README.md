# ScreenShooter

## Synopsis

This is a sample Selenium program to take screenshots of webpages. It's specially made for
long webpages that won't fit in a standard size image. It does this by resizing the browser window and 
then scrolling down to the bottom of the pages snapping screenshots all the way down.
 
## Running
You have to have geckodriver in your path or specify it's location with a property
```text
mvn clean test
```