package co.edu.udea.certificacion.menu.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.ABOUT_BUTTON;

public class SelectAboutOption implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ABOUT_BUTTON)
        );
    }
}