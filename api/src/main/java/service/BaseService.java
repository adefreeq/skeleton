package service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;

import static io.restassured.RestAssured.given;


public class BaseService {
    @Getter
    @Setter
    static Response response;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public RequestSpecification request() {

        setUpRestAssuredObjectMapper();

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter());

        return given()
                .spec(builder.build())
                .header("X-Requested-With", "XMLHttpRequest")
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1");
    }

    public void setUpRestAssuredObjectMapper() {
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                (cls, charset) -> {
                    ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    mapper.registerModule(new Jackson2HalModule());
                    return mapper;
                }
        ));
    }
}
