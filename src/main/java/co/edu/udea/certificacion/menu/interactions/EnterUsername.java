package co.edu.udea.certificacion.menu.interactions;

import net.serenitybdd.screenplay.actions.Enter;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.USERNAME_FIELD;

public class EnterUsername implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue("standard_user").into(USERNAME_FIELD)
        );
    }
}