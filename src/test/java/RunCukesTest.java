import com.github.bogdanlivadariu.reporting.cucumber.builder.CucumberReportBuilder;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.CucumberTagStatement;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(plugin = {"pretty", "json:target/cucumber-report.json"})
public class RunCukesTest {
	private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {         
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
    	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    	
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
        List<String> files = Arrays.asList("./target/cucumber-report.json");
        CucumberReportBuilder cucumberReportBuilder = new CucumberReportBuilder(files, "target");
        cucumberReportBuilder.writeReportsOnDisk();

    }


}
