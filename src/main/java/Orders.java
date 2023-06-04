import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Orders {

    //Создание заказа
    public Response getCorrectNewOrder(NewOrder newOrder) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .body(newOrder)
                .post("orders");
        response.then();
        return  response;
    }

    //Получение списка заказов
    public Response getAllOrders() {
        Response response = given()
                .baseUri("http://qa-scooter.praktikum-services.ru/api/v1/")
                .header("Content-type", "application/json")
                .get("orders");
        response.then();
        return response;
    }
}