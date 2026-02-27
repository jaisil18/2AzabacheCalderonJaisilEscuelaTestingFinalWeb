# AutoWeb1 — Automatización Web SauceDemo

Proyecto de automatización funcional sobre el sitio [SauceDemo](https://www.saucedemo.com/), construido con **Serenity BDD + Cucumber (BDD)** siguiendo el patrón **Page Object Model (POM)** y buenas prácticas de QA.

---

## Descripción

Esta suite automatiza los flujos críticos de la aplicación SauceDemo, cubriendo escenarios de **Happy Path** y **Unhappy Path**:

| Tag | Descripción |
|---|---|
| `@LoginExitoso` | Login correcto con credenciales válidas |
| `@CompraExitosa` | Flujo completo de compra de un producto |
| `@UsuarioBloqueado` | Intento de login con usuario bloqueado |
| `@CredencialesInvalidas` | Intento de login con credenciales incorrectas |
| `@LogoutExitoso` | Cierre de sesión desde el menú lateral |
| `@OrdenamientoPorPrecio` | Ordenamiento de productos por precio (mayor a menor) |
| `@EliminacionProducto` | Eliminación de producto desde el carrito |
| `@ContinuarComprando` | Botón "Continuar Comprando" desde el carrito |
| `@ResetAppState` | Reinicio del estado de la aplicación desde el menú |
| `@VerCarritoVacio` | Verificación de carrito vacío al inicio de sesión |
| `@CheckoutDatosFaltantes` | Validación de error al dejar nombre vacío en checkout |

---

## Estructura del Proyecto

```
AutoWeb1/
├── src/
│   ├── main/java/          # (Vacío — solo test code)
│   └── test/
│       ├── java/AutoWeb/
│       │   ├── pages/          # Page Objects (LoginPage, InventoryPage, CartPage, etc.)
│       │   ├── steps/          # Serenity Step Libraries (lógica de negocio)
│       │   ├── stepdefinitions/# Glue Cucumber ↔ Steps
│       │   └── runners/        # Suite Runner (JUnit 5 Platform)
│       └── resources/
│           ├── features/
│           │   └── saucedemo/
│           │       └── saucedemo.feature  # Escenarios en Gherkin
│           └── serenity.conf              # Configuración y credenciales
└── pom.xml
```

---

## Manejo de Credenciales

Las credenciales **no están expuestas en los archivos Gherkin**. Se gestionan de forma segura en `src/test/resources/serenity.conf`:

```hocon
environments {
  default {
    credentials.valid.username = "standard_user"
    credentials.valid.password = "secret_sauce"
    credentials.locked.username = "locked_out_user"
    ...
  }
}
```

---

## Cómo Ejecutar los Tests

### Requisitos previos
- Java 11+
- Maven 3.8+
- Google Chrome instalado

### Ejecutar todos los tests de SauceDemo
```bash
mvn clean verify -Dcucumber.filter.tags="@SauceDemo"
```

### Ejecutar solo Happy Path
```bash
mvn clean verify -Dcucumber.filter.tags="@HappyPath"
```

### Ejecutar solo Unhappy Path
```bash
mvn clean verify -Dcucumber.filter.tags="@UnhappyPath"
```

### Ejecutar un escenario específico
```bash
mvn clean verify -Dcucumber.filter.tags="@LoginExitoso"
```

---

## Reporte de Resultados (Serenity BDD)

Tras la ejecución, Serenity genera automáticamente un **reporte HTML completo** con capturas de pantalla, pasos detallados y estadísticas:

```
target/site/serenity/index.html
```

Ábrelo en cualquier navegador para ver:
- Gráficos de resultados (passed/failed)
- Timeline de ejecución
- Detalle paso a paso de cada escenario

---

## Stack Tecnológico

| Tecnología | Versión |
|---|---|
| Java | 11 |
| Serenity BDD | 4.1.20 |
| Cucumber | 7.x |
| JUnit 5 | Platform |
| Selenium WebDriver | Integrado por Serenity |
| Maven | 3.8+ |

---

## Autor

**Jaisil Calderón** — Escuela de Testing
Proyecto final de automatización web.
