package br.com.bootcamp.runTest;

import org.junit.runner.RunWith;
import br.com.bootcamp.settings.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, dryRun = false,
        snippets = SnippetType.CAMELCASE, plugin = {"pretty", "json:target/cucumber.json"},
        features = {"./src/test/resources/"}, glue = {
        "br.com.projeto.web.steps","br.com.projeto.app.steps",
        "br.com.projeto.configuration","br.com.projeto.commons",
        "br.com.projeto.bean"},
        tags = {"@test-web", "@app"})

public class runTest extends BaseTest {

}
