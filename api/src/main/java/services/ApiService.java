package services;

import context.TestConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiService extends BaseService {
    private final TestConfig testConfig;

    public void sendGetRequest(String endpoint) {
        log.info("Base URI: {}", testConfig.getBaseUri());
        log.info("Sending GET request to endpoint: {}", endpoint);

        response = given()
                .baseUri(testConfig.getBaseUri())
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
