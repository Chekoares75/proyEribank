package tcs.semillero.grupo1.proyEribank.pageObjects;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jhlabs.image.CellularFilter.Point;
import com.jhlabs.image.LightFilter.PointLight;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAccessibilityId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.webdriver.WebDriverFacade;

public class PagePago extends MobilePageObject {
	double saldo;
	double saldoNuevo;
	double monto;
	
	
	String idActualizacion="android:id/button1";
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
	String xpathO="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[1]";
	String xpathD="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[11]";
	
	
	public void iniciarApp() throws MalformedURLException {
	}

	public PagePago(WebDriver driver) {
		super(driver);
	}

	public void ingresarUsuario(String usuario) {
		boolean Actualizacion=element(By.id(idActualizacion)).isVisible();
		if (Actualizacion==true) {
			element(By.id(idActualizacion)).click();
		}
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

	public String enviarPais(String pais) {
		return txtListaPais += pais + "\"]";
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
	
		public void swipe(String pais)
		
		{
			System.out.println(enviarPais(pais));
			int i=0;
			boolean condicion=element(By.xpath(enviarPais(pais))).isVisible();
			System.out.println(condicion);
		while (condicion==false){
			i++;
			System.out.println(i);
			WebDriver facade = getDriver();
			WebDriver driver =((WebDriverFacade) facade).getProxiedDriver();
			TouchAction ta = new TouchAction((PerformsTouchActions) driver);
			MobileElement CoorO = (MobileElement) driver.findElement(By.xpath(xpathO));
			org.openqa.selenium.Point locationO = CoorO.getLocation();
			MobileElement CoorD = (MobileElement) driver.findElement(By.xpath(xpathD));
			org.openqa.selenium.Point locationD = CoorD.getLocation();
			PointOption LocO = new PointOption();
			LocO.withCoordinates(locationO.x, locationO.y);
			PointOption LocD = new PointOption();
			LocD.withCoordinates(locationD.x, locationD.y);
			ta.press(LocD).waitAction().moveTo(LocO).release().perform();
		}
		System.out.println("1." +condicion);
		element(By.xpath(enviarPais(pais))).click();
		}
	}

