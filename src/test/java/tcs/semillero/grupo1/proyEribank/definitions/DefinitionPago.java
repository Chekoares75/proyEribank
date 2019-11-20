package tcs.semillero.grupo1.proyEribank.definitions;

import java.net.MalformedURLException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import tcs.semillero.grupo1.proyEribank.steps.StepPago;

public class DefinitionPago {
	@Steps
	StepPago objStepPago;
	@Given("^Ingreso a la aplicacion$")
	public void ingresoALaAplicacion() throws MalformedURLException {
		objStepPago.ingresoALaAplicacion();
	}

	@Given("^ingreso usuario \"([^\"]*)\" y contrasena \"([^\"]*)\"$")
	public void ingresoUsuarioYContrasena(String usuario, String clave) {
		objStepPago.ingresoUsuarioYContrasena(usuario, clave);
	}

	@Given("^valida balance$")
	public void validaBalance() {
		objStepPago.validaBalance();
	}

	@Given("^pulsar boton pago$")
	public void pulsarBotonPago() {
		objStepPago.pulsarBotonPago();
	}

	@When("^llenar formulario y enviar datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void llenarFormularioYEnviarDatos(String telefono, String nombre, String monto, String pais) {
		objStepPago.llenarFormularioYEnviarDatos(telefono, nombre, monto, pais);
	}

	@Then("^verificar balance final$")
	public void verificarBalanceFinal() {
		objStepPago.verificarBalanceFinal();

	}
}
