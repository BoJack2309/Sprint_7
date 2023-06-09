import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderTest {

    private NewOrder newOrder;
    private OrdersClient ordersClient;

    @Parameterized.Parameters(name = "Цвет. Тестовые данные: {0} {1} {2} {3}")
    public static Object[][] getColor() {
        return new Object[][]{
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}},
        };
    }

    @Parameterized.Parameter(0)
    public String[] color;

    @Before
    public void setup() {
        newOrder = OrderSettings.createNewOrder(NewOrder.color);
        ordersClient = new OrdersClient();
    }

    @Test
    @DisplayName("Создание заказа")
    public void createOrder() {
        ordersClient.getCorrectNewOrder(OrderSettings.createNewOrder(NewOrder.color))
                .then().statusCode(201)
                .and()
                .body("track", notNullValue());
    }
}