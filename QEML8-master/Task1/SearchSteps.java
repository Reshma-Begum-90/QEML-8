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
    public void launch_browser(String browser) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        if (browser.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void search_product(String product) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(product);
        searchBox.submit();
    }

    @Then("I should see results for {string}")
    public void verify_results(String product) {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(product.toLowerCase()));
        driver.quit();
    }
}
