package steps;

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
public class DemoSteps {

    @Then("the response should contain the following user ids: {int}, {int}, {int}, {int}, {int}, {int}")
    public void verifyUserIdsInResponse(int id1, int id2, int id3, int id4, int id5, int id6) {
        List<Integer> expectedIds = List.of(id1, id2, id3, id4, id5, id6);

        UserListResponse response = BaseService.getResponse().as(UserListResponse.class);
        List<Integer> actualIds = response.getData()
                .stream()
                .map(User::getId)
                .collect(Collectors.toList());

        assertThat(actualIds)
                .as("Verify user IDs match expected values")
                .containsExactlyElementsOf(expectedIds);
    }



}