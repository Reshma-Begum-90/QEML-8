package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class SearchSteps {

    RemoteWebDriver driver;

    @Given("I launch the {string} browser on cloud")
    public void launch_browser(String browser) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);
        caps.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
        caps.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));
        caps.setCapability("name", "Cloud Grid Search Test");

        driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
        driver.get("https://www.demoblaze.com/");
    }

    @When("I search for {string}")
    public void search_product(String product) {
        driver.findElement(By.id("navbarExample")).sendKeys(product); // Replace with actual search logic
    }

    @Then("I should see results related to {string}")
    public void verify_search(String product) {
        String pageSource = driver.getPageSource().toLowerCase();
        assertTrue(pageSource.contains(product.toLowerCase()));
        driver.quit();
    }
}
