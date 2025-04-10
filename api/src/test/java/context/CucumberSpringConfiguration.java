package context;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@CucumberContextConfiguration
@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("qa")
public class CucumberSpringConfiguration {
}