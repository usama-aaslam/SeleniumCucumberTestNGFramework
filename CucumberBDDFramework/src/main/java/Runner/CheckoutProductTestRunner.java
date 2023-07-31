package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/Features/sauceDemo.feature",    //the path of feature file
        glue= {"stepDefinition"},     // tha path of step definition file
        plugin= { "pretty", "html:target/cucumber-reports.html"},
        dryRun = false,    // it will check if any step is not defined in definition file
        monochrome = true,     //displays the console output in readable format
        tags = "@SmokeTest"   //execute test cases on the basis of tags
)

public class CheckoutProductTestRunner {
}
