import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrdersClient {

    @Step("Создание нового заказа")
    public Response getCorrectNewOrder(NewOrder newOrder) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(newOrder)
                .post(Constants.ORDERS_ROOT);
        response.then();
        return  response;
    }

    @Step("Получение списка заказов")
    public Response getAllOrders() {
        Response response = given()
                .baseUri(Constants.getBaseUrl())
                .header("Content-type", "application/json")
                .get(Constants.ORDERS_ROOT);
        response.then();
        return response;
    }
}