package co.edu.udea.certificacion.menu.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.RESET_APP_STATE_BUTTON;

public class SelectResetAppStateOption implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(RESET_APP_STATE_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(RESET_APP_STATE_BUTTON)
        );
    }

    public static SelectResetAppStateOption selectResetAppStateOption() {
        return new SelectResetAppStateOption();
    }
} 