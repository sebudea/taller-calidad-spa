package co.edu.udea.certificacion.menu.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.MENU_BUTTON;

public class OpenMenu implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MENU_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(MENU_BUTTON)
        );
    }

    public static OpenMenu openMenu() {
        return new OpenMenu();
    }
}