package steps;

import Model.CreateUserResponse;
import Model.responsedto.User;
import Model.responsedto.UserListResponse;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import service.BaseService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class UserSteps {

    @Then("the response should contain the following user ids: (.*)$")
    public void verifyUserIdsInResponse(String idsCsv) {
        List<Integer> expectedIds = Arrays.stream(idsCsv.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        UserListResponse response = BaseService.getResponse().as(UserListResponse.class);
        List<Integer> actualIds = response.getData().stream().map(User::getId).collect(Collectors.toList());

        assertThat(actualIds).as("Verify user IDs match expected values").containsExactlyElementsOf(expectedIds);
    }

    @Then("the response should contain name (.*) and job (.*)$")
    public void theResponseShouldContainNameAndJob(String name, String job) {
        CreateUserResponse response = BaseService.getResponse().as(CreateUserResponse.class);
        assertThat(List.of(response.getName(), response.getJob())).containsExactly(name, job);
    }
}