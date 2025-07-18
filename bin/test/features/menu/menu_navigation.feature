# author: Sebastian Aristizabal y Juan Sebastian Munoz
Feature: navegacion del menu de SauceDemo
  Como usuario de SauceDemo
  Quiero usar el menu de navegacion
  Para acceder a diferentes secciones de la aplicacion

  Scenario: navegacion exitosa a la seccion about
    Given que he iniciado sesion como usuario estandar
    When abro el menu y selecciono la opcion About
    Then puedo ver la seccion About

  Scenario: Cerrar sesion exitosamente desde el menu
    Given que he iniciado sesion como usuario estandar
    When abro el menu y selecciono la opcion Logout
    Then debo volver a la pagina de inicio de sesion

  Scenario: Reiniciar estado de la app desde el menu
    Given que he iniciado sesion como usuario estandar
    When agrego un producto al carrito y abro el menu y selecciono la opcion Reset App State
    Then el carrito debe estar vacio y los botones de los productos deben estar en Add to cart
