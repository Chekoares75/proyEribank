#Author: Semillero grupo 1
@tag
Feature: Automatizacion de servicio de pagos

  Background: loguin exitoso
    Given Ingreso a la aplicacion
    And ingreso usuario "company" y contrasena "company"
    And valida balance

  @tag1
  Scenario Outline: Realizar pago
    Given pulsar boton pago
    When llenar formulario y enviar datos <telefono> <nombre> <monto> <pais>
    Then verificar balance final

    Examples: 
      | telefono  | nombre   | monto | pais       |
      | "1234567" | "grupoA" | "20"  | "Colombia" |
