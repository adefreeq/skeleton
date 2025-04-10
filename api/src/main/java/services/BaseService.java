package services;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;


public class BaseService {
    @Getter
    @Setter
    static Response response;
}
