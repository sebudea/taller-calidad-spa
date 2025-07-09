package co.edu.udea.certificacion.menu.tasks;

import co.edu.udea.certificacion.menu.interactions.OpenMenu;
import co.edu.udea.certificacion.menu.interactions.SelectResetAppStateOption;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToResetAppState implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                new OpenMenu(),
                SelectResetAppStateOption.selectResetAppStateOption()
        );
    }

    public static NavigateToResetAppState navigateToResetAppState() {
        return instrumented(NavigateToResetAppState.class);
    }
} 