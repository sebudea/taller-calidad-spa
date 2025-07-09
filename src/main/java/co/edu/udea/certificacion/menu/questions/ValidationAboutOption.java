package co.edu.udea.certificacion.menu.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.ABOUT_HEADER;

public class ValidationAboutOption implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return ABOUT_HEADER.resolveFor(actor).isVisible();
    }

    public static ValidationAboutOption onPage() {
        return new ValidationAboutOption();
    }
}