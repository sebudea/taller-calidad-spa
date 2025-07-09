package co.edu.udea.certificacion.menu.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class GetCurrentUrl implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        actor.remember("current_url", currentUrl);
    }
}