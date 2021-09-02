package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)



@CucumberOptions
        (

                features = "Features/myp2Login.feature",
                glue = "stepDefinitions",
//                plugin = { "pretty", "json:target/cucumber_html_reports/Cucumber.json",
//                        "junit:target/cucumber_html_reports/Cucumber.xml",
//                        "rerun:target/cucumber_html_reports/cucumber.txt",
//                        "html:target/cucumber_html_reports/cucumber.html",
//                        "json:target/cucumber.json",
//                        "junit:target/cucumber.xml"
//                },
//                monochrome = true
                plugin = {"pretty","json:target/cucumber.json", "html:target/site/cucumber-pretty"
                }
        )

public class TestRunner {
}
