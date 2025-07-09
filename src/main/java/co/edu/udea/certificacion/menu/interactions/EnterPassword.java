package co.edu.udea.certificacion.menu.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.PASSWORD_FIELD;

public class EnterPassword implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("secret_sauce").into(PASSWORD_FIELD)
        );
    }
}