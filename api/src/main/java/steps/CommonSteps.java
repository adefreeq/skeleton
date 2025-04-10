package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import services.ApiService;
import services.BaseService;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class CommonSteps {
    private String endpoint;
    private final ApiService apiService;

    @Given("the API endpoint (.*)$")
    public void setApiEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("I send a GET request")
    public void sendGetRequest() {
        apiService.sendGetRequest(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        assertThat(BaseService.getResponse().getStatusCode())
                .as("Response status code")
                .isEqualTo(expectedStatusCode);
    }


}