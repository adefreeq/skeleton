package service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiService extends BaseService {
    @Value("${demo.uri}")
    private String uri;

    public void get(String endpoint) {
        response = request().baseUri(uri)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public <T> void post(T requestBody, String path) {
        response = request().baseUri(uri)
                .body(requestBody)
                .when()
                .post(path)
                .then()
                .extract()
                .response();
    }
}