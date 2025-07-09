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
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MenuNavigationStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que he iniciado sesion como usuario estandar")
    public void queHeIniciadoSesionComoUsuarioEstandar() {
        OnStage.theActorCalled("usuario").attemptsTo(
                LoginToSauceDemo.loginToSauceDemo()
        );
    }

    @When("abro el menu y selecciono la opcion About")
    public void abroElMenuYSeleccionoAbout() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToAbout.navigateToAbout()
        );
    }

    @Then("puedo ver la seccion About")
    public void puedoVerLaSeccionAbout() {
        theActorInTheSpotlight().should(
                seeThat(ValidationAboutOption.onPage())
        );
    }

    @When("abro el menu y selecciono la opcion Logout")
    public void abroElMenuYSeleccionoLogout() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToLogout.navigateToLogout()
        );
    }

    @Then("debo volver a la pagina de inicio de sesion")
    public void deboVolverALaPaginaDeInicioDeSesion() {
        theActorInTheSpotlight().should(
                seeThat(ValidationLoginPage.onPage())
        );
    }

    @When("agrego un producto al carrito y abro el menu y selecciono la opcion Reset App State")
    public void agregoProductoYSeleccionoResetAppState() {
        theActorInTheSpotlight().attemptsTo(
                AddProductToCart.addProductToCart(),
                NavigateToResetAppState.navigateToResetAppState()
        );
    }

    @Then("el carrito debe estar vacio y los botones de los productos deben estar en Add to cart")
    public void elCarritoDebeEstarVacioYLosBotonesDebenEstarEnAddToCart() {
        theActorInTheSpotlight().should(
                seeThat(ValidationResetAppState.onPage())
        );
    }
}