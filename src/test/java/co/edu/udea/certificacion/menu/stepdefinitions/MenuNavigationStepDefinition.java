package co.edu.udea.certificacion.menu.stepdefinitions;

import co.edu.udea.certificacion.menu.questions.ValidationAboutOption;
import co.edu.udea.certificacion.menu.questions.ValidationLoginPage;
import co.edu.udea.certificacion.menu.questions.ValidationResetAppState;
import co.edu.udea.certificacion.menu.tasks.LoginToSauceDemo;
import co.edu.udea.certificacion.menu.tasks.NavigateToAbout;
import co.edu.udea.certificacion.menu.tasks.NavigateToLogout;
import co.edu.udea.certificacion.menu.tasks.NavigateToResetAppState;
import co.edu.udea.certificacion.menu.interactions.AddProductToCart;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class MenuNavigationStepDefinition {

    private static final String ACTOR_NAME = "cliente";
    private Actor cliente;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        cliente = OnStage.theActorCalled(ACTOR_NAME);
    }

    @Given("que he iniciado sesion como usuario estandar")
    public void queHeIniciadoSesionComoUsuarioEstandar() {
        cliente.attemptsTo(
                LoginToSauceDemo.loginToSauceDemo());
    }

    @When("abro el menu y selecciono la opcion About")
    public void abroElMenuYSeleccionoAbout() {
        cliente.attemptsTo(
                NavigateToAbout.navigateToAbout());
    }

    @Then("puedo ver la seccion About")
    public void puedoVerLaSeccionAbout() {
        cliente.should(
                seeThat(ValidationAboutOption.onPage()));
    }

    @When("abro el menu y selecciono la opcion Logout")
    public void abroElMenuYSeleccionoLogout() {
        cliente.attemptsTo(
                NavigateToLogout.navigateToLogout());
    }

    @Then("debo volver a la pagina de inicio de sesion")
    public void deboVolverALaPaginaDeInicioDeSesion() {
        cliente.should(
                seeThat(ValidationLoginPage.onPage()));
    }

    @When("agrego un producto al carrito y abro el menu y selecciono la opcion Reset App State")
    public void agregoProductoYSeleccionoResetAppState() {
        cliente.attemptsTo(
                AddProductToCart.addProductToCart(),
                NavigateToResetAppState.navigateToResetAppState());
    }

    @Then("el carrito debe estar vacio y los botones de los productos deben estar en Add to cart")
    public void elCarritoDebeEstarVacioYLosBotonesDebenEstarEnAddToCart() {
        cliente.should(
                seeThat(ValidationResetAppState.onPage()));
    }
}