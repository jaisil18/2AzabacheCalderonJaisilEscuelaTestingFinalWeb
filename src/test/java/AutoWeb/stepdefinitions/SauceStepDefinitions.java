package AutoWeb.stepdefinitions;

import AutoWeb.steps.SauceSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class SauceStepDefinitions {

    @Steps
    SauceSteps sauceSteps;

    private EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    @Dado("que el usuario navega a la pagina de logeo de SauceDemo")
    public void queElUsuarioNavegaALaPaginaDeLogeo() {
        sauceSteps.abrirPaginaLogeo();
    }

    @Cuando("ingresa credenciales validas")
    public void ingresaCredencialesValidas() {
        String user = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("credentials.valid.username");
        String pass = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("credentials.valid.password");
        sauceSteps.login(user, pass);
    }

    @Cuando("ingresa credenciales de usuario bloqueado")
    public void ingresaCredencialesBloqueadas() {
        String user = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("credentials.locked.username");
        String pass = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("credentials.locked.password");
        sauceSteps.login(user, pass);
    }

    @Cuando("ingresa credenciales invalidas")
    public void ingresaCredencialesInvalidas() {
        String user = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("credentials.invalid.username");
        String pass = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("credentials.invalid.password");
        sauceSteps.login(user, pass);
    }

    @Entonces("deberia visualizar el titulo del inventario {string}")
    public void visualizarTituloInventario(String titulo) {
        sauceSteps.verificarTituloInventario(titulo);
    }

    @Entonces("deberia visualizar un mensaje de error {string}")
    public void visualizarMensajeErrorString(String error) {
        sauceSteps.verificarMensajeError(error);
    }

    @Entonces("deberia visualizar un mensaje de error de credenciales invalidas {string}")
    public void visualizarMensajeErrorCredenciales(String error) {
        sauceSteps.verificarMensajeError(error);
    }

    @Y("agrega un producto al carrito")
    public void agregaUnProductoAlCarrito() {
        sauceSteps.agregarProductoAlCarrito();
    }

    @Y("navega al carrito de compras")
    public void navegaAlCarritoDeCompras() {
        sauceSteps.navegarAlCarrito();
    }

    @Y("procede al checkout con sus datos")
    public void procedeAlCheckoutConSusDatos() {
        // Primero hace click en Checkout desde el carrito, luego completa el formulario
        sauceSteps.clickEnCheckout();
        sauceSteps.completarDatosCheckout("Juan", "Perez", "12345");
    }

    @Y("finaliza la compra")
    public void finalizaLaCompra() {
        sauceSteps.finalizarCompra();
    }

    @Entonces("deberia visualizar el mensaje de exito {string}")
    public void verificarMensajeCompra(String mensaje) {
        sauceSteps.verificarMensajeCompra(mensaje);
    }

    @Y("cierra sesion desde el menu")
    public void cierraSesionDesdeElMenu() {
        sauceSteps.cerrarSesionMenu();
    }

    @Entonces("deberia retornar a la pantalla de login original")
    public void verificarRetornoPantallaLogin() {
        sauceSteps.verificarPantallaLoginVisible();
    }

    @Entonces("el carrito principal debería estar totalmente vacio")
    public void verificarCarritoVacio() {
        sauceSteps.verificarCarritoVacio();
    }

    @Y("procede a hacer click en checkout")
    public void procedeAHacerClickEnCheckout() {
        sauceSteps.clickEnCheckout();
    }

    @Y("intenta continuar sin ingresar nombre")
    public void intentaContinuarSinIngresarNombre() {
        sauceSteps.continuarCheckoutVacio();
    }

    @Entonces("deberia visualizar el mensaje de error de informacion {string}")
    public void visualizarMensajeErrorCheckout(String error) {
        sauceSteps.verificarErrorCheckout(error);
    }

    @Y("selecciona el ordenamiento por precio {string}")
    public void seleccionaElOrdenamiento(String opcion) {
        sauceSteps.ordenarPor(opcion);
    }

    @Entonces("el primer producto de la lista deberia ser {string}")
    public void verificarPrimerProductoString(String producto) {
        sauceSteps.verificarPrimerProducto(producto);
    }

    @Y("agrega el producto {string} al carrito")
    public void agregarProductoStringAlCarrito(String nombreProducto) {
        sauceSteps.agregarProductoEspecifico(nombreProducto);
    }

    @Y("elimina el producto {string} del carrito")
    public void eliminaElProductoDelCarrito(String nombreProducto) {
        sauceSteps.eliminarProductoEspecifico(nombreProducto);
    }

    @Y("hace clic en el boton Continuar Comprando")
    public void haceClicBotonContinuarComprando() {
        sauceSteps.continuarComprando();
    }

    @Y("reinicia el estado de la aplicacion desde el menu")
    public void reiniciaEstadoDeAplicacion() {
        sauceSteps.reiniciarAplicacion();
    }

    @Entonces("el contador del carrito no deberia existir")
    public void elContadorDelCarritoNoDeberiaExistir() {
        sauceSteps.verificarLogoCarritoInvisible();
    }
}
