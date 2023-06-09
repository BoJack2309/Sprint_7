
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


public class CourierClient {

    @Step("Регистрация нового курьера")
    public Response createNewCourier(NewCourier newCourier) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .and()
                .body(newCourier)
                .when()
                .post(Constants.COURIER);
            response.then();
                    return response;
    }

    @Step("Регистрация с некорректными данными")
    public Response getIncorrectCourier(NewCourier newCourier) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .and()
                .body(newCourier)
                .when()
                .post(Constants.COURIER);
    }

    @Step("Удаление курьера")
    public Response deleteCourier(CourierLogin courierLogin) {
        Integer id = given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(courierLogin)
                .post(Constants.COURIER_LOGIN)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", notNullValue())
                .extract()
                .path("id");

        return given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .delete(Constants.COURIER + id);
    }

    @Step("Логин курьера")
    public Response login(CourierLogin courierLogin) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .and()
                .body(courierLogin)
                .when()
                .post(Constants.COURIER_LOGIN);
    }
}