package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class BasePage {
    public ChromeOptions options;
    public WebDriver driver;

    private By shopping_cart_container = By.className("shopping_cart_container");
    private By burgerMenuButton = By.id("react-burger-menu-btn");


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    protected WebElement find (By locator){
        return driver.findElement(locator);
    }

      protected void click (By locator){
        find(locator).click();
    }
    protected boolean isDisplayed (By locator){
        try {
            return find(locator).isDisplayed();
        }
        catch (NoSuchElementException exc){
            return false;
        }
    }

    protected void type(String text, By locator){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public CartPage clickOnCart(){
        click(shopping_cart_container);
        return new CartPage(driver);
    }

    public BurgerMenu clickOnBurgerMenu()  {
        click(burgerMenuButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return new BurgerMenu(driver);
    }




}