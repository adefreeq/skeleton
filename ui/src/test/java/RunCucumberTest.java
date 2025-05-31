import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/reports/cucumber-report.html", "json:target/reports/cucumber-report.json"},
        features = {"classpath:features"},
        glue = {"context", "steps"},
        tags = "@regression and not @database and not @defect")
public class RunCucumberTest {

}