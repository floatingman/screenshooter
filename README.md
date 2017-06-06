# ScreenShooter

## Synopsis

This is a sample [Selenium](http://docs.seleniumhq.org/) program to take screenshots of web pages. It's specially made for
long web pages that won't fit in a standard size image. It does this by resizing the browser window and 
then scrolling down to the bottom of the pages snapping screenshots all the way down.
 
## Running
You have to have [geckodriver](https://github.com/mozilla/geckodriver) in your path or specify it's location with a 
property ```-Dwebdriver.gecko.driver=/<pathtogeckodriver>```
```text
mvn clean test
```