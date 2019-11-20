package tcs.semillero.grupo1.proyEribank.pageObjects;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.annotations.findby.By;

public class PagePago extends MobilePageObject {
	double saldo;
	double saldoNuevo;
	double monto;
	String edtUsuario = "com.experitest.ExperiBank:id/usernameTextField";
	String edtContrasena = "com.experitest.ExperiBank:id/passwordTextField";
	String btnIngresar = "com.experitest.ExperiBank:id/loginButton";
	String btnPagos = "com.experitest.ExperiBank:id/makePaymentButton";
	String txtSaldo = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View\r\n";

	String txtTelefono = "com.experitest.ExperiBank:id/phoneTextField";
	String txtNombre = "com.experitest.ExperiBank:id/nameTextField";
	String txtMonto = "com.experitest.ExperiBank:id/amountTextField";
	String txtPais = "com.experitest.ExperiBank:id/countryTextField";
	String btnEnviar = "com.experitest.ExperiBank:id/sendPaymentButton";

	String btnSeleccionPais = "com.experitest.ExperiBank:id/countryButton";
	String lstVwPaises = "com.experitest.ExperiBank:id/countryList";

	String btnConfirmar = "android:id/button1";

	String txtListaPais = "//android.widget.ListView/android.widget.TextView[@text=\"";

	public void iniciarApp() throws MalformedURLException {
	}

	public PagePago(WebDriver driver) {
		super(driver);
	}

	public void ingresarUsuario(String usuario) {
		element(By.id(this.edtUsuario)).sendKeys(usuario);
	}

	public void ingresarContrasena(String contrasena) {
		element(By.id(this.edtContrasena)).sendKeys(contrasena);

	}

	public void darClicEnBotonIngresar() {
		element(By.id(this.btnIngresar)).click();
	}

	public void validarMensajeSaldo() {
		waitFor(4).seconds();
		String mensajeAValidar = element(By.xpath(this.txtSaldo)).getText().toString();
		String palabras[] = mensajeAValidar.split(":");
		palabras[1] = palabras[1].substring(0, palabras[1].length() - 1);
		saldo = Double.parseDouble(palabras[1]);
	}

	public void verificarSaldo() {
		waitFor(4).seconds();
		String mensajeAValidar = element(By.xpath(this.txtSaldo)).getText().toString();
		String palabras[] = mensajeAValidar.split(":");
		palabras[1] = palabras[1].substring(0, palabras[1].length() - 1);
		saldoNuevo = Double.parseDouble(palabras[1]);
		Assert.assertEquals((saldo - monto), saldoNuevo, 0.1);
	}

	public void pulsarPayment() {
		element(By.id(this.btnPagos)).click();
		;
	}

	public void enviarTelefono(String telefono) {
		element(By.id(txtTelefono)).sendKeys(telefono);
	}

	public void enviarNombre(String nombre) {
		element(By.id(txtNombre)).sendKeys(nombre);
	}

	public void enviarMonto(String monto) {
		element(By.id(txtMonto)).sendKeys(monto);
		this.monto = Double.parseDouble(monto);
	}

	public void enviarPais(String pais) {
		txtListaPais += pais + "\"]";
	}

	public void pulsarEnviar() {
		element(By.id(btnEnviar)).click();
	}

	public void pulsarConfirmar() {
		element(By.id(btnConfirmar)).click();
	}

	public void pulsarSeleccionPais() {
		element(By.id(btnSeleccionPais)).click();
	}

	public void seleccionarPais() {
		
				
	}
}
