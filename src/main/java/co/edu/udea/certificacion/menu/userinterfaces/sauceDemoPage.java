package co.edu.udea.certificacion.menu.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class sauceDemoPage {
    public static final Target USERNAME_FIELD = Target.the("Campo de usuario").located(By.xpath("//input[@id='user-name']"));
    public static final Target PASSWORD_FIELD = Target.the("Campo de contraseña").located(By.xpath("//input[@id='password']"));
    public static final Target LOGIN_BUTTON = Target.the("Boton de login").located(By.xpath("//input[@id='login-button']"));
    public static final Target MENU_BUTTON = Target.the("Boton de menu").located(By.xpath("//button[@id='react-burger-menu-btn']"));    
    public static final Target ABOUT_BUTTON = Target.the("Opcion about").located(By.xpath("//a[@id='about_sidebar_link']"));
    public static final Target ABOUT_HEADER = Target.the("Header de la seccion about").located(By.xpath("//*[@id='__next']/header/div/div/div[1]/div/a/div[1]/img"));
    public static final Target LOGOUT_BUTTON = Target.the("Opcion logout").located(By.xpath("//a[@id='logout_sidebar_link']"));
    public static final Target RESET_APP_STATE_BUTTON = Target.the("Opcion reset app state").located(By.xpath("//a[@id='reset_sidebar_link']"));
    public static final Target SHOPPING_CART_BUTTON = Target.the("Boton de carrito de compras").located(By.xpath("//a[@class='shopping_cart_link']"));
    public static final Target PRODUCT_NAME = Target.the("Nombre del producto").located(By.xpath("//div[@class='inventory_item_name']"));
    public static final Target ADD_TO_CART_BUTTON = Target.the("Boton de agregar al carrito").located(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
    public static final Target REMOVE_FROM_CART_BUTTON = Target.the("Boton de remover del carrito").located(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
}