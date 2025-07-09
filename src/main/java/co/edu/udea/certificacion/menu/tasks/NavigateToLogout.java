package co.edu.udea.certificacion.menu.tasks;

import co.edu.udea.certificacion.menu.interactions.OpenMenu;
import co.edu.udea.certificacion.menu.interactions.SelectLogoutOption;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToLogout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                new OpenMenu(),
                SelectLogoutOption.selectLogoutOption()
        );
    }

    public static NavigateToLogout navigateToLogout() {
        return instrumented(NavigateToLogout.class);
    }
} 