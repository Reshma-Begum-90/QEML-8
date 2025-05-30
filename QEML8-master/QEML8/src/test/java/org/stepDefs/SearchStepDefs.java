package org.stepDefs;

import io.cucumber.java.en.*;
import org.hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchStepDefs {

    WebDriver driver = Hooks.getDriver();

    @Given("I open the website")
    public void i_open_the_website() {
        driver.get("https://www.target.com/");
    }

    @When("I search for {string}")
    public void i_search_for(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("search"))).sendKeys(product);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='search']"))).click();
    }

    @Then("I should see search results for {string}")
    public void i_should_see_search_results_for(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class = 'h-margin-r-x1']/parent::h2/following-sibling::span")));
        String actualText = searchHeader.getText().replace("“", "").replace("”", "");
        String expectedText = "for " + product;
        System.out.println("Expected: " + expectedText);
        System.out.println("Actual: " + actualText);
        Assert.assertEquals(actualText, expectedText);
    }
}
