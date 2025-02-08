package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"classpath:features"}, glue = {"stepdefinition"},
        tags = "@addToCart", monochrome = false, dryRun = false,
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"})

public class MainRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
