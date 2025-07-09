package co.edu.udea.certificacion.menu.tasks;

import co.edu.udea.certificacion.menu.interactions.EnterUsername;
import co.edu.udea.certificacion.menu.interactions.EnterPassword;
import co.edu.udea.certificacion.menu.interactions.ClickLoginButton;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginToSauceDemo implements Task {

    public LoginToSauceDemo() {}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                new EnterUsername(),
                new EnterPassword(),
                new ClickLoginButton()
        );
    }

    public static LoginToSauceDemo loginToSauceDemo() {
        return instrumented(LoginToSauceDemo.class);
    }
}