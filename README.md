# Automation-Testing-Helios
# Proyecto de Automatización de Pruebas

Este proyecto está diseñado para automatizar pruebas de funcionalidad usando Selenium, Cucumber, y el patrón Page Object Model (POM). Incluye la automatización de procesos de login y compra de productos en la página de Rahulshettyacademy.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- `src/test/java/`: Contiene el código de prueba en Java.
  - `base/`: Clases base y configuración general para las pruebas.
  - `pages/`: Implementación de las páginas usando el patrón POM.
  - `stepDefinitions/`: Definiciones de pasos para los escenarios de Cucumber.
  - `runners/`: Configuración de ejecución de pruebas con JUnit y Cucumber.
  - `features/`: Archivos de características de Cucumber en formato `.feature`.

## Requisitos

- Java 11 o superior
- Maven
- Selenium WebDriver
- Cucumber
- JUnit
- Geckodriver (para Firefox)
