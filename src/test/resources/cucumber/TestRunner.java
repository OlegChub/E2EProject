package cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/cucumber/features/",
        glue= "src/test/resources/cucumber/stepDefinition/",
        strict = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
