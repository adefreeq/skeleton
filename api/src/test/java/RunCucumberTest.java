import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"context", "ui"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true,
        publish = true,
        tags = "@regression"
)
public class RunCucumberTest {
}