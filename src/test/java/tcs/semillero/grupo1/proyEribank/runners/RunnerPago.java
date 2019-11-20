package tcs.semillero.grupo1.proyEribank.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\", glue = "tcs.semillero.grupo1.proyEribank.definitions", snippets = SnippetType.CAMELCASE)

public class RunnerPago {

}
