package context;

import drivers.DriverFactory;
import io.cucumber.java.After;
import org.springframework.beans.factory.annotation.Autowired;

public class CucumberHooks {

    @Autowired
    private DriverFactory driverFactory;

    @After
    public void tearDown() {
        driverFactory.quitDriver();
    }
}
