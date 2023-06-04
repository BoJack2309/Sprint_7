
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


public class Courier {

    //регистрация нового курьера
    public Response createNewCourier(NewCourier newCourier) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .and()
                .body(newCourier)
                .when()
                .post("courier");
            response.then();
                    return response;
    }

    //регистрация с некорректными данными
    public Response getIncorrectCourier(NewCourier newCourier) {
        return given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .and()
                .body(newCourier)
                .when()
                .post("courier");
    }

    //удаление курьера
    public Response deleteCourier(CourierLogin courierLogin) {
        Integer id = given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .body(courierLogin)
                .post("courier/login")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", notNullValue())
                .extract()
                .path("id");

        return given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .delete("courier" + id);
    }

    //логин
    public Response login(CourierLogin courierLogin) {
        return given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .and()
                .body(courierLogin)
                .when()
                .post("courier/login");
    }
}