package com.iiddd.base.extensions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

import static com.iiddd.base.constants.Constants.ATTR_VALUE;
import static com.iiddd.base.constants.Constants.EMPTY_STRING;

public class MyElement {

    private WebElement element;
    private WebDriver driver;

    public MyElement(By by, WebDriver driver) {
        this.driver = driver;
        try {
            this.element = getVisibleElements(by).get(0).getWebElement();
        } catch (IndexOutOfBoundsException iobException) {
            throw new NotFoundException("Element not found");
        }
    }

    public MyElement(By by, MyElement rootElement) {
        try {
            this.element = getVisibleElements(by, rootElement).get(0).getWebElement();
        } catch (IndexOutOfBoundsException iobException) {
            throw new NotFoundException("Element not found");
        }
    }

    public MyElement(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
    }

    public void click() {
        element.click();
    }

    private WebElement getWebElement() {
        return element;
    }

    public void submit() {
        element.submit();
    }

    public void clear() {
        element.clear();
    }

    public String getTagName() {
        return element.getTagName();
    }

    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public String getText() {
        return element.getText();
    }

    public List<MyElement> findMyElements(By by) {
        return element.findElements(by)
                .stream()
                .map(el -> new MyElement(by, driver))
                .collect(Collectors.toList());
    }

    public List<MyElement> findRelativeMyElements(By by) {
        return element.findElements(by)
                .stream()
                .map(el -> new MyElement(by, this))
                .collect(Collectors.toList());
    }

    public MyElement findMyElement(By by) {
        return findMyElements(by).get(0);
    }

    public MyElement findRelativeMyElement(By by) {
        return findRelativeMyElements(by).get(0);
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public Point getLocation() {
        return element.getLocation();
    }

    public Dimension getSize() {
        return element.getSize();
    }

    public Rectangle getRect() {
        return element.getRect();
    }

    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }

    public WebElement findDomElement(By by) {
        return element.findElement(by);
    }

    public List<WebElement> findDomElements(By by) {
        return element.findElements(by);
    }

    public void moveToElement() {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void clearAndType(String value) {
        while (!element.getAttribute(ATTR_VALUE).equals(EMPTY_STRING)) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.sendKeys(value);
    }

    private List<MyElement> getVisibleElements(By by) {
        return driver.findElements(by)
                .stream()
                .filter(el -> el.isDisplayed())
                .map(el -> new MyElement(el, driver))
                .collect(Collectors.toList());
    }

    private List<MyElement> getVisibleElements(By by, MyElement element) {
        return element.findDomElements(by)
                .stream()
                .filter(el -> el.isDisplayed())
                .map(el -> new MyElement(el, driver))
                .collect(Collectors.toList());
    }
}