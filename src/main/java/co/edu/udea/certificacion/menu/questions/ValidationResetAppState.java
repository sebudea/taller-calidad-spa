package co.edu.udea.certificacion.menu.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.SHOPPING_CART_BUTTON;
import static co.edu.udea.certificacion.menu.userinterfaces.sauceDemoPage.ADD_TO_CART_BUTTON;

public class ValidationResetAppState implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        // Verificar que el carrito está vacío (no tiene número)
        String cartText = Text.of(SHOPPING_CART_BUTTON).answeredBy(actor);
        boolean isCartEmpty = cartText.isEmpty();

        // Verificar que el botón está en estado "Add to cart"
        boolean isAddToCartVisible = Visibility.of(ADD_TO_CART_BUTTON).answeredBy(actor);

        return !(isCartEmpty && isAddToCartVisible);
    }

    public static ValidationResetAppState onPage() {
        return new ValidationResetAppState();
    }
} 