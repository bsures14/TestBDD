
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features", // Path to your feature files
        glue = {"stepdefinitions","Utility"}, // Package containing your step definitions
        plugin = {
                "pretty", // Console output format
                "html:target/cucumber-reports.html", // HTML report
                "json:target/cucumber.json" // JSON report
        },
        monochrome = true, // Readable console output
        dryRun = false, // If true, checks if mappings are correct without executing tests
        tags = "@PurchaseMetalWatch" // Run specific scenarios with a tag
)
public class CucumberTestRunner {
        @BeforeClass
        public static void setupProperties(){
                System.setProperty("BrowserType", "Chrome");
        }
}
