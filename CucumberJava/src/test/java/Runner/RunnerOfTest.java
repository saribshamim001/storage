package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/Features/GoogleSearch.feature","src/test/resources/Features/AdactinHotelReservation.feature"},
monochrome = false, glue = "TestDefinitions")

public class RunnerOfTest extends AbstractTestNGCucumberTests {
	
}
