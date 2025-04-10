package steps;

import Model.responsedto.DemoResponse;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import services.BaseService;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class DemoSteps {

    @Then("the response should contain valid demo data")
    public void verifyDemoResponse() {
        DemoResponse demoResponse = BaseService.getResponse().as(DemoResponse.class);
        assertThat(demoResponse).isNotNull();
    }

}