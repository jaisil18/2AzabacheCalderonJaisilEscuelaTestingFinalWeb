    # language: es
    @SauceDemo @Regresion
    Característica: Automatización web SauceDemo
    Como usuario de SauceDemo
    Quiero automatizar el login y compras en la página
    Para asegurar la calidad del producto

    Antecedentes:
    Dado que el usuario navega a la pagina de logeo de SauceDemo

    @HappyPath @LoginExitoso
    Escenario: Verificar el logeo correcto con credenciales validas
    Cuando ingresa credenciales validas
    Entonces deberia visualizar el titulo del inventario "Products"

    @HappyPath @CompraExitosa
    Escenario: Verificar el flujo de compra completa de un producto
    Cuando ingresa credenciales validas
    Y agrega un producto al carrito
    Y navega al carrito de compras
    Y procede al checkout con sus datos
    Y finaliza la compra
    Entonces deberia visualizar el mensaje de exito "Thank you for your order!"

    @UnhappyPath @UsuarioBloqueado
    Escenario: Verificar el logeo con un usuario bloqueado
    Cuando ingresa credenciales de usuario bloqueado
    Entonces deberia visualizar un mensaje de error "Epic sadface: Sorry, this user has been locked out."

    @UnhappyPath @CredencialesInvalidas
    Escenario: Verificar el logeo con credenciales invalidas
    Cuando ingresa credenciales invalidas
    Entonces deberia visualizar un mensaje de error de credenciales invalidas "Epic sadface: Username and password do not match any user in this service"

    @HappyPath @LogoutExitoso
    Escenario: Verificar el cierre de sesion correcto
    Cuando ingresa credenciales validas
    Y cierra sesion desde el menu
    Entonces deberia retornar a la pantalla de login original

    @HappyPath @OrdenamientoPorPrecio
    Escenario: Verificar ordenamiento de productos por precio de mayor a menor
    Cuando ingresa credenciales validas
    Y selecciona el ordenamiento por precio "Price (high to low)"
    Entonces el primer producto de la lista deberia ser "Sauce Labs Fleece Jacket"

    @HappyPath @EliminacionProducto
    Escenario: Verificar eliminacion de producto desde el carrito
    Cuando ingresa credenciales validas
    Y agrega el producto "Sauce Labs Bolt T-Shirt" al carrito
    Y navega al carrito de compras
    Y elimina el producto "Sauce Labs Bolt T-Shirt" del carrito
    Entonces el carrito principal debería estar totalmente vacio

    @HappyPath @ContinuarComprando
    Escenario: Verificar el boton Continuar Comprando desde el carrito
    Cuando ingresa credenciales validas
    Y navega al carrito de compras
    Y hace clic en el boton Continuar Comprando
    Entonces deberia visualizar el titulo del inventario "Products"

    @HappyPath @ResetAppState
    Escenario: Verificar la funcionalidad de reinicio del estado de la aplicacion
    Cuando ingresa credenciales validas
    Y agrega un producto al carrito
    Y reinicia el estado de la aplicacion desde el menu
    Entonces el contador del carrito no deberia existir
    
    @HappyPath @LogoutExitoso
    Escenario: Verificar el cierre de sesion correcto
    Cuando ingresa credenciales validas
    Y cierra sesion desde el menu
    Entonces deberia retornar a la pantalla de login original

    @HappyPath @VerCarritoVacio
    Escenario: Verificar el carrito de compras vacio inicial
    Cuando ingresa credenciales validas
    Y navega al carrito de compras
    Entonces el carrito principal debería estar totalmente vacio

    @UnhappyPath @CheckoutDatosFaltantes
    Escenario: Verificar validacion al dejar nombre vacio en checkout
    Cuando ingresa credenciales validas
    Y agrega un producto al carrito
    Y navega al carrito de compras
    Y procede a hacer click en checkout
    Y intenta continuar sin ingresar nombre
    Entonces deberia visualizar el mensaje de error de informacion "Error: First Name is required"
