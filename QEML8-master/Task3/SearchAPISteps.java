package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SearchApiSteps {

    private String product;
    private Response response;

    @Given("the search query is {string}")
    public void the_search_query_is(String product) {
        this.product = product;
    }

    @When("I send a GET request to /search endpoint")
    public void i_send_get_request() {
        response = given()
                .queryParam("q", product)
                .when()
                .get("http://localhost:8080/search"); // Update with your actual URL
    }

    @Then("the response should contain {string}")
    public void response_should_contain(String expected) {
        response.then().statusCode(200);
        response.then().body("results", hasItem(containsStringIgnoringCase(expected)));
    }
}
