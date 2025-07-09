package co.edu.udea.certificacion.menu.tasks;

import co.edu.udea.certificacion.menu.interactions.EnterUsername;
import co.edu.udea.certificacion.menu.interactions.EnterPassword;
import co.edu.udea.certificacion.menu.interactions.ClickLoginButton;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.USERNAME_FIELD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginToSauceDemo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/"),
                WaitUntil.the(USERNAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                new EnterUsername(),
                new EnterPassword(),
                new ClickLoginButton()
        );
    }

    public static LoginToSauceDemo loginToSauceDemo() {
        return instrumented(LoginToSauceDemo.class);
    }
}