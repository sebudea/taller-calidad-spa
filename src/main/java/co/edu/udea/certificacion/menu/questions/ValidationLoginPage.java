package co.edu.udea.certificacion.menu.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.USERNAME_FIELD;

public class ValidationLoginPage implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(USERNAME_FIELD).answeredBy(actor);
    }

    public static ValidationLoginPage onPage() {
        return new ValidationLoginPage();
    }
} 