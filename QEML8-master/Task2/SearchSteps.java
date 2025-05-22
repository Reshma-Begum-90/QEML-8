package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class SearchSteps {

    WebDriver driver;

    @Given("I launch the {string} browser")
    public void i_launch_browser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser.toLowerCase());
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String product) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(product);
        searchBox.sendKeys(Keys.ENTER);
    }

    @Then("I should see results for {string}")
    public void i_should_see_results(String product) {
        assertTrue(driver.getTitle().toLowerCase().contains(product.toLowerCase()));
        driver.quit();
    }
}
