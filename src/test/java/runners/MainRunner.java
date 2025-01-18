package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"classpath:features"}, glue = {"stepdefinition"},
                tags = " @autoExe", monochrome = false, dryRun = false,
                plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"})

public class MainRunner extends AbstractTestNGCucumberTests {
}
