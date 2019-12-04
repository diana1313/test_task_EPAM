package steps.hooks;

import cucumber.api.java.Before;
import helpers.PropertiesReader;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;

public class Hooks {
    @Before
    public void setupDriver() {
        ChromeDriverManager.getInstance(DriverManagerType.valueOf(PropertiesReader.getPropertyValue("webdriver.driver"))).setup();
    }

}
