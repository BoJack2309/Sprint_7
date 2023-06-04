import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CourierLoginTest {

    //авторизация под существующим логином и паролем
    @Test
    public void courierAuthorisationWithCorrectSettings() {
        NewCourier newCourier = CourierSettings.getAllCorrectCourierSettings();

        given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .body(newCourier)
                .post("courier");

        Response response = given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .body(CourierSettings.getAllCorrectCourierSettings())
                .post("courier/login");
        response.then()
                .statusCode(200)
                .and()
                .assertThat().body("id", notNullValue());
    }

    //авторизация c некорректным логином
    @Test
    public void courierAuthorisationWithoutCorrectLogin() {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .body(LoginSettings.incorrectLogin())
                .post("courier/login");
        response.then().statusCode(404)
                .and()
                .assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    //авторизация без логина
    @Test
    public void courierAuthorisationWithoutLogin() {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .body(LoginSettings.withoutLogin())
                .post("courier/login");
        response.then().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }
}