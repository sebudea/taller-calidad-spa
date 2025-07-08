Te explico cada carpeta y el orden típico de desarrollo en el patrón Screenplay:

**Estructura de Carpetas:**

1. **📂userinterfaces**

   - Contiene los localizadores/selectores de elementos UI
   - Define dónde están los elementos en la página
   - Ejemplo: botones, campos de texto, tablas, etc.

2. **📂tasks**

   - Representa las acciones de alto nivel que realiza el actor
   - Combina varias interacciones para lograr un objetivo
   - Ejemplo: "LoginTask", "CreateUserTask", "SearchProductTask"

3. **📂interactions**

   - Acciones atómicas/básicas que realiza el actor
   - Son los bloques más pequeños de acciones
   - Ejemplo: click, escribir texto, seleccionar opción

4. **📂questions**

   - Verifica el estado del sistema
   - Obtiene datos para validaciones
   - Ejemplo: "IsButtonEnabled", "GetTotalPrice", "IsUserLoggedIn"

5. **📂models**

   - Objetos de dominio/negocio
   - Representa las estructuras de datos
   - Ejemplo: "User", "Product", "Order"

6. **📂exceptions**

   - Manejo personalizado de errores
   - Excepciones específicas del negocio
   - Ejemplo: "LoginFailedException", "InvalidDataException"

7. **📂integrations**

   - Conexiones con sistemas externos
   - Configuración de APIs, bases de datos
   - Ejemplo: "ApiConfig", "DatabaseConnection"

8. **📂utils**
   - Utilidades y helpers
   - Funciones comunes reutilizables
   - Ejemplo: "DateUtils", "StringUtils"

**Orden de Desarrollo Típico:**

1. **Primer Paso: Definir Features**

   ```gherkin
   Feature: Login
   Scenario: Usuario exitoso
   Given que estoy en la página de login
   When ingreso credenciales válidas
   Then debería ver la página principal
   ```

2. **Segundo Paso: User Interfaces**

   ```java
   public class LoginPage {
       public static Target USERNAME_FIELD = Target.the("campo usuario")
           .located(By.id("username"));
       public static Target PASSWORD_FIELD = Target.the("campo contraseña")
           .located(By.id("password"));
   }
   ```

3. **Tercer Paso: Interactions (si necesitas personalizadas)**

   ```java
   public class Enter implements Interaction {
       private String text;
       private Target field;

       public void performAs(Actor actor) {
           actor.attemptsTo(
               Click.on(field),
               SendKeys.of(text).into(field)
           );
       }
   }
   ```

4. **Cuarto Paso: Tasks**

   ```java
   public class Login implements Task {
       private String username;
       private String password;

       public void performAs(Actor actor) {
           actor.attemptsTo(
               Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
               Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
               Click.on(LoginPage.LOGIN_BUTTON)
           );
       }
   }
   ```

5. **Quinto Paso: Questions**

   ```java
   public class IsLoggedIn implements Question<Boolean> {
       public Boolean answeredBy(Actor actor) {
           return WebElementQuestion.valueOf(HomePage.WELCOME_MESSAGE)
               .answeredBy(actor)
               .isVisible();
       }
   }
   ```

6. **Sexto Paso: Models (según necesidad)**

   ```java
   public class User {
       private String username;
       private String password;
       // getters, setters
   }
   ```

7. **Séptimo Paso: Step Definitions**

   ```java
   public class LoginSteps {
       @When("ingreso credenciales válidas")
       public void enterValidCredentials() {
           theActorInTheSpotlight().attemptsTo(
               Login.withCredentials("user", "pass")
           );
       }
   }
   ```

8. **Octavo Paso: Integrations/Exceptions (según necesidad)**
   ```java
   public class ApiConnection {
       public static Response callEndpoint() {
           // configuración de llamadas API
       }
   }
   ```

**Tips de Desarrollo:**

1. Siempre empieza por los features (historias de usuario en Gherkin)
2. Luego identifica los elementos UI necesarios
3. Crea las Tasks que representan las acciones del usuario
4. Implementa las Questions para las validaciones
5. Añade Models, Exceptions e Integrations según sea necesario
6. Los Utils se van creando a medida que identificas código reutilizable

¿Te gustaría que profundice en algún aspecto específico de alguna de estas capas o su implementación?
