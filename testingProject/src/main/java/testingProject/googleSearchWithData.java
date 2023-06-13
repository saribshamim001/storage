package testingProject;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"features/googleSearch.feature"},
monochrome = false, glue = "TestDefinitions")

public class googleSearchWithData {

}


