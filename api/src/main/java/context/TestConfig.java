package context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
@Profile("qa")
public class TestConfig {
    @Value("${api.base.uri}")
    private String baseUri;

    public String getBaseUri() {
        log.info("Base URI from config: {}", baseUri);
        return baseUri;
    }
}