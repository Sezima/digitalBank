package co.wemiguel.digitalbank.automation.ui.steps;

import co.wemiguel.digitalbank.automation.ui.pages.RegistrationPage;
import co.wemiguel.digitalbank.automation.ui.utils.ConfigReader;
import co.wemiguel.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static co.wemiguel.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationSteps {


    RegistrationPage registrationPage = new RegistrationPage(getDriver());


    @Given("user navigates to Digital Bank signup page")
    public void user_navigates_to_digital_bank_signup_page() {
        getDriver().get(ConfigReader.getPropertiesValue("digtalbank.registrationpageurl"));
        assertEquals("Digital Bank", getDriver().getTitle(), "Registration page Title mismatch");
    }
    @When("User creates account with following fields with mocked email and ssn")
    public void user_creates_account_with_following_fields_with_mocked_email_and_ssn(List<Map<String, String>> registrationPageTestDataListOfMap) {
        registrationPage.fillOutRegistrationForm(registrationPageTestDataListOfMap);
    }
    @Then("user should be displayed with the message {string}")
    public void user_should_be_displayed_with_the_message(String expectedSuccessMessage) {

    }

}
