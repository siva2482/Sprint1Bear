package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Sprint1Bear\\src\\test\\java\\Feature\\Beartable.feature",
		glue={"StepDef"}
		)
public class TestRunner {

}
