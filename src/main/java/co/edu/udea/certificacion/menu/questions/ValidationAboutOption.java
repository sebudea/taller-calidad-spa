package co.edu.udea.certificacion.menu.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;


public class ValidationAboutOption implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        return currentUrl.contains("saucelabs.com");
    }

    public static ValidationAboutOption onPage() {
        return new ValidationAboutOption();
    }
}