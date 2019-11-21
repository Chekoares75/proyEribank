package tcs.semillero.grupo1.proyEribank.steps;

import java.net.MalformedURLException;

import net.thucydides.core.annotations.Step;
import tcs.semillero.grupo1.proyEribank.pageObjects.PagePago;

public class StepPago {
	
	PagePago objPagePago;
	@Step
	public void ingresoALaAplicacion() throws MalformedURLException {
		objPagePago.iniciarApp();
	}

	@Step
	public void ingresoUsuarioYContrasena(String usuario, String clave) {
		objPagePago.ingresarUsuario(usuario);
		objPagePago.ingresarContrasena(clave);
		objPagePago.darClicEnBotonIngresar();
	}

	@Step
	public void validaBalance() {
		objPagePago.validarMensajeSaldo();
	}

	@Step
	public void pulsarBotonPago() {
		objPagePago.pulsarPayment();
	}

	@Step
	public void llenarFormularioYEnviarDatos(String telefono, String nombre, String monto, String pais) throws InterruptedException {
		objPagePago.enviarTelefono(telefono);
		objPagePago.enviarNombre(nombre);
		objPagePago.enviarMonto(monto);
		objPagePago.enviarPais(pais);
		objPagePago.pulsarSeleccionPais();
		objPagePago.seleccionarPais();
		Thread.sleep(3000);
		objPagePago.swipe();
		//objPagePago.pulsarEnviar();
		//objPagePago.pulsarConfirmar();
	}

	@Step
	public void verificarBalanceFinal() {
		objPagePago.verificarSaldo();
	}
}
