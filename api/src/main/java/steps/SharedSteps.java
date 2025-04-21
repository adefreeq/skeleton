package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import service.ApiService;
import service.BaseService;

import java.util.Map;

import static datatables.DataTableConverter.toMap;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class SharedSteps {
    private String endpoint;
    private final ApiService apiService;

    @When("I send a GET request to the API endpoint (.*)$")
    public void sendGetRequest(String endpoint) {
        apiService.get(endpoint);
    }

    @When("I send a POST request to the API endpoint (.*) with body:$")
    public void sendPostRequest(String endpoint, @Transpose DataTable dataTable) {
        Map<String, String> body = toMap(dataTable);
        apiService.post(body, endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        assertThat(BaseService.getResponse().getStatusCode())
                .as("Response status code")
                .isEqualTo(expectedStatusCode);
    }
}