package br.com.bootcamp.settings;

import br.com.bootcamp.enums.Browser;
import br.com.bootcamp.settings.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseTest {
    @Before(value = "@web")
    public void beforeWeb(){
        System.out.println("Iniciando Browser Web");
        initializeWebApplication(Browser.CHROME_WINDOWS);
    }

    @After(value = "@web")
    public void afterWeb(){
        System.out.println("Fechando Web");
        closeWeb();
    }
}
