package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Reporter;
import pages.GoogleHomePO;
import pages.GoogleSearchPO;


public class StepDefinition {
	
	private GoogleHomePO ghPO;
	private GoogleSearchPO gsPO;
	
	public StepDefinition(GoogleHomePO ghPO, GoogleSearchPO gsPO) {
		this.ghPO = ghPO;
		this.gsPO = gsPO;
	}
	
	@Given("Go to google page")
	public void given() {
		Reporter.log("Go to google page");
		ghPO.get();
	}


	@When("Enter search {string}")
	public void when(String search) {
		Reporter.log("Enter search "+search);
		gsPO = ghPO.performSearch(search);
	}
}
