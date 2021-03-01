package com.testing.team;

import Driver.DriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.RandomHelper;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestSuits extends DriverManager {

    RandomHelper randomHelper=new RandomHelper();

    @Test
    public void doSearch(){
        WebElement searchTextBox = driver.findElement(By.cssSelector("#searchTerm"));
        searchTextBox.sendKeys("nike");
        searchTextBox.sendKeys(Keys.ENTER);
        String actualUrl = driver.getCurrentUrl();
        assertThat(actualUrl,endsWith("nike"));
    }

    @Test
    public void basketTest(){
        WebElement searchTextBox = driver.findElement(By.cssSelector("#searchTerm"));
        searchTextBox.sendKeys("nike");
        searchTextBox.sendKeys(Keys.ENTER);
        List<WebElement> products = driver.findElements(By.cssSelector("a[data-test=component-product-card-title]"));
        int indexNumber = randomHelper.randomNumber(products.size());
        WebElement selectProduct = products.get(indexNumber);
        String actualProduct = selectProduct.getText();
        selectProduct.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".add-to-trolley-main button[data-test=\"add-to-trolley-button-button\"]")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Go to Trolley")).sendKeys(Keys.ENTER);
        String basketProduct = driver.findElement(By.cssSelector("a[data-e2e=product-name]")).getText();

    }
}
