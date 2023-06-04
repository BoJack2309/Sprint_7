import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderTest {

    NewOrder newOrder;
    Orders orders;

    @Parameterized.Parameters()
    public static Object[][] getColor() {
        return new Object[][]{
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}},
        };
    }

    @Before
    public void setup() {
        newOrder = OrderSettings.createNewOrder(NewOrder.color);
        orders = new Orders();
    }

    @Test
    public void createOrder() {
        orders.getCorrectNewOrder(OrderSettings.createNewOrder(NewOrder.color))
                .then().statusCode(201)
                .and()
                .body("track", notNullValue());
    }
}