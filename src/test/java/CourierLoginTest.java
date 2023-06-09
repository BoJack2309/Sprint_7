import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CourierLoginTest {

    /*
    @Test
    @DisplayName("Авторизация с корректными значениями")
    public void courierAuthorisationWithCorrectSettings() {
        NewCourier newCourier = CourierSettings.getAllCorrectCourierSettings();

        given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(newCourier)
                .post(Constants.COURIER);

        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(CourierSettings.getAllCorrectCourierSettings())
                .post(Constants.COURIER_LOGIN);
        response.then()
                .statusCode(200)
                .and()
                .assertThat().body("id", notNullValue());
    }*/

    @Test
    @DisplayName("Авторизация с корректными значениями")
    public void courierAuthorisationWithCorrectSettings() {
        CourierLogin courierLogin = new CourierLogin();
        Response authWithCorrectSettings = courierLogin.authWithCorrectsSettings();
        authWithCorrectSettings.then().statusCode(200).and().assertThat().body("id", notNullValue());
    }

    /*
    @Test
    @DisplayName("Авторизация с некорректным логином")
    public void courierAuthorisationWithoutCorrectLogin() {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(LoginSettings.incorrectLogin())
                .post(Constants.COURIER_LOGIN);
        response.then().statusCode(404)
                .and()
                .assertThat().body("message", equalTo("Учетная запись не найдена"));
    }*/

    @Test
    @DisplayName("Авторизация с некорректным логином")
    public void courierAuthorisationWithoutCorrectLogin() {
        CourierLogin courierLogin = new CourierLogin();
        Response authWithIncorrectLogin = courierLogin.AuthorisationWithIncorrectLogin();
        authWithIncorrectLogin.then().statusCode(404).and().assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    /*
    @Test
    @DisplayName("Авторизация без логина")
    public void courierAuthorisationWithoutLogin() {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(LoginSettings.withoutLogin())
                .post(Constants.COURIER_LOGIN);
        response.then().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }
    ?
     */
    @Test
    @DisplayName("Авторизация без логина")
    public void courierAuthorisationWithoutLogin() {
        CourierLogin courierLogin = new CourierLogin();
        Response authWithoutLogin = courierLogin.AuthorisationWithoutLogin();
        authWithoutLogin.then().statusCode(400).and().assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }
}