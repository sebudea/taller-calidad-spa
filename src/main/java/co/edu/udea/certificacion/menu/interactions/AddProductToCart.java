package co.edu.udea.certificacion.menu.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.ADD_TO_CART_BUTTON;

public class AddProductToCart implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ADD_TO_CART_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ADD_TO_CART_BUTTON)
        );
    }

    public static AddProductToCart addProductToCart() {
        return new AddProductToCart();
    }
} 