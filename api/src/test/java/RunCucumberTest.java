import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"steps", "context"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,
        publish = true,
        tags = "@demo"
)
public class RunCucumberTest {
}
