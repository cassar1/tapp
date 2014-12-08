import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty","html:target/cucumber"}, glue ={"test.assign.stepdefs"}, features = {"tests/resources/features"},monochrome=true)
public class RunTest {

}
