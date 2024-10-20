
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"stepdefinitions","Utility"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = false,
        dryRun = false,
        tags = "@PurchaseMetalWatch"
)
public class CucumberTestRunner {
        @BeforeClass
        public static void setupProperties(){
                System.setProperty("BrowserType", "Chrome");
        }
}
