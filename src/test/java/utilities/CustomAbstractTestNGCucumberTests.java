package utilities;

import base.DriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

@CucumberOptions(
        strict = true,
        plugin = {"json:target/cucumber-report-feature-composite.json"}
)
public class CustomAbstractTestNGCucumberTests {
    private RemoteWebDriver driver = DriverManager.getDriver();
    private TestNGCucumberRunner testNGCucumberRunner;

    public CustomAbstractTestNGCucumberTests(){

    }

    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass() throws Exception {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios"
    )
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        this.testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider(
            parallel = true
    )
    public Object[][] scenarios() {
        return this.testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(
            alwaysRun = true
    )
    public void tearDownClass() throws Exception {
        this.testNGCucumberRunner.finish();
    }
}