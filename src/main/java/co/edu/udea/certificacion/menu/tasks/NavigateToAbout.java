package co.edu.udea.certificacion.menu.tasks;

import co.edu.udea.certificacion.menu.interactions.OpenMenu;
import co.edu.udea.certificacion.menu.interactions.SelectAboutOption;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToAbout implements Task {

    public NavigateToAbout() {}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                new OpenMenu(),
                new SelectAboutOption()
        );
    }

    public static NavigateToAbout navigateToAbout() {
        return instrumented(NavigateToAbout.class);
    }
}