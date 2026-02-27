package AutoWeb.steps;

import AutoWeb.pages.SauceCartPage;
import AutoWeb.pages.SauceCheckoutPage;
import AutoWeb.pages.SauceInventoryPage;
import AutoWeb.pages.SauceLoginPage;
import AutoWeb.pages.SauceMenuPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import static org.assertj.core.api.Assertions.assertThat;

public class SauceSteps {

    @Steps
    SauceLoginPage loginPage;

    @Steps
    SauceInventoryPage inventoryPage;

    @Steps
    SauceCartPage cartPage;

    @Steps
    SauceCheckoutPage checkoutPage;

    @Steps
    SauceMenuPage menuPage;

    @Step("Navegar a la página de login")
    public void abrirPaginaLogeo() {
        loginPage.open();
    }

    @Step("Realizar login con usuario {0}")
    public void login(String usuario, String clave) {
        loginPage.enterUsername(usuario);
        loginPage.enterPassword(clave);
        loginPage.clickLoginButton();
    }

    @Step("Verificar visibilidad del título del inventario")
    public void verificarTituloInventario(String tituloEsperado) {
        String tituloActual = inventoryPage.getTitle();
        assertThat(tituloActual).as("El título del inventario no coincide. Esperado: '" + tituloEsperado
                + "', Actual: '" + tituloActual + "'").isEqualTo(tituloEsperado);
    }

    @Step("Agregar el primer producto al carrito")
    public void agregarProductoAlCarrito() {
        inventoryPage.addFirstProductToCart();
    }

    @Step("Navegar al carrito y dar checkout")
    public void irAlCarritoYCheckout() {
        inventoryPage.clickShoppingCart();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        cartPage.clickCheckout();
    }

    @Step("Completar formulario de checkout con {0}, {1} y {2}")
    public void completarDatosCheckout(String nombre, String apellido, String codigoPostal) {
        checkoutPage.enterFirstName(nombre);
        checkoutPage.enterLastName(apellido);
        checkoutPage.enterPostalCode(codigoPostal);
        checkoutPage.clickContinue();
    }

    @Step("Finalizar compra")
    public void finalizarCompra() {
        checkoutPage.clickFinish();
    }

    @Step("Verificar mensaje de compra finalizada")
    public void verificarMensajeCompra(String mensajeEsperado) {
        String mensajeActual = checkoutPage.getCompleteMessage();
        assertThat(mensajeActual).as("El mensaje de compra no coincide. Esperado: '" + mensajeEsperado + "', Actual: '"
                + mensajeActual + "'").isEqualTo(mensajeEsperado);
    }

    @Step("Verificar mensaje de error de login")
    public void verificarMensajeError(String errorEsperado) {
        String errorActual = loginPage.getErrorMessage();
        assertThat(errorActual)
                .as("El mensaje de error no coincide. Esperado: '" + errorEsperado + "', Actual: '" + errorActual + "'")
                .isEqualTo(errorEsperado);
    }

    @Step("Verificar mensaje de error al hacer checkout")
    public void verificarErrorCheckout(String errorEsperado) {
        String errorActual = checkoutPage.getErrorMessage();
        assertThat(errorActual).as("El error del checkout no es el esperado").isEqualTo(errorEsperado);
    }

    @Step("Cerrar sesion (Logout) desde el menú lateral")
    public void cerrarSesionMenu() {
        menuPage.openMenu();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        menuPage.clickLogout();
    }

    @Step("Verificar presencia del boton de login")
    public void verificarPantallaLoginVisible() {
        assertThat(loginPage.isLoginButtonVisible()).as("El botón de login debería estar visible luego del logout")
                .isTrue();
    }

    @Step("Navegar al carrito sin interactuar")
    public void navegarAlCarrito() {
        inventoryPage.clickShoppingCart();
        // Esperar a que la página del carrito cargue completamente
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    @Step("Verificar que el carrito se encuentra vacío")
    public void verificarCarritoVacio() {
        assertThat(cartPage.isCartEmpty()).as("El carrito tiene elementos, debería estar vacío").isTrue();
    }

    @Step("Proceder al checkout")
    public void clickEnCheckout() {
        cartPage.clickCheckout();
    }

    @Step("Continuar en Checkout sin proveer información")
    public void continuarCheckoutVacio() {
        checkoutPage.clickContinue();
    }

    @Step("Reiniciar estado de la aplicacion desde el menú")
    public void reiniciarAplicacion() {
        menuPage.openMenu();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        menuPage.clickResetAppState();
        menuPage.closeMenu();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    @Step("Agregar producto especifico al carrito: {0}")
    public void agregarProductoEspecifico(String nombreProducto) {
        inventoryPage.addProductByName(nombreProducto);
    }

    @Step("Ordenar inventario por: {0}")
    public void ordenarPor(String opcion) {
        inventoryPage.sortBy(opcion);
    }

    @Step("Verificar el primer producto de la lista")
    public void verificarPrimerProducto(String nombreEsperado) {
        String nombreActual = inventoryPage.getFirstProductName();
        assertThat(nombreActual).as("El primer producto despues de ordenar no coincide").isEqualTo(nombreEsperado);
    }

    @Step("Eliminar producto especifico: {0}")
    public void eliminarProductoEspecifico(String nombreProducto) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        cartPage.removeProductByName(nombreProducto);
    }

    @Step("Continuar Comprando desde el carrito")
    public void continuarComprando() {
        // Esperar más tiempo para que la página del carrito esté completamente cargada
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        cartPage.clickContinueShopping();
    }

    @Step("Verificar que el logo de cantidad del carrito no sea visible")
    public void verificarLogoCarritoInvisible() {
        assertThat(inventoryPage.isCartBadgeVisible()).as("El globo de cantidad en el carrito no debio estar visible")
                .isFalse();
    }
}
