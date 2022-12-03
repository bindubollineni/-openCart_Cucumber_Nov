package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// features = {"./Features/Login.feature"},
		//features = { "./Features/LoginDDT.feature" },
				features = { "./Features/LoginDDTusingExcel.feature" },

		glue = "stepDefinitions", plugin = { "pretty", "html:reports/myreport.html", "json:reports/myreport.json",
		// "rerun:targer/rerun.txt",
		}, dryRun = false, monochrome = true
//	tags= "@sanity"

)

public class TestRunner {

}
