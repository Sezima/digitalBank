package co.wemiguel.digitalbank.automation.ui.steps;

import co.wemiguel.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void afterScenario(Scenario scenario) {
        Driver.takeScreenShot(scenario);
        Driver.closeDriver();


    }
}
