package co.edu.udea.certificacion.menu.runners.menu;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/menu/menu_navigation.feature",
        glue = "co.edu.udea.certificacion.menu.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class MenuRunner {}