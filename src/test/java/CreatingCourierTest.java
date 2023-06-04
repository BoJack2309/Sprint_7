import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class CreatingCourierTest {

    NewCourier newCourier;
    Courier courier;

    @Before
    public void setup() {
        newCourier = NewCourier.getAllCorrectCourierSettings(); //
        courier = new Courier();
    }

    //курьера можно создать -- все поля заполнены корректно
    @Test
    public void createCourierWithCorrectSettings() {
        courier.createNewCourier(CourierSettings.getAllCorrectCourierSettings())
                .then().statusCode(201)
                .and()
                .assertThat().body("ok", equalTo(true));
    }

    //курьера можно создать -- поле firstname опущено
    @Test
    public void createCourierWithCorrectSettingsWithoutFirstName() {
        courier.createNewCourier(CourierSettings.getCourierSettingsWithoutFirstName())

                .then().statusCode(201)
                .and()
                .assertThat().body("ok", equalTo(true));
    }

    //негативная проверка создания курьера без пароля
    @Test
    public void createCourierWithoutPassword(){
        courier.getIncorrectCourier(CourierSettings.getCourierSettingsWithoutPassword())
                .then().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    //негативная проверка создания курьера без логина
    @Test
    public void createCourierWithoutLogin(){
        courier.getIncorrectCourier(CourierSettings.getCourierSettingsWithoutLogin())
                .then().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    //негативная проверка создания курьера без логина и пароля
    @Test
    public void createCourierWithoutLoginAndPassword(){
        courier.getIncorrectCourier(CourierSettings.getCourierSettingsWithoutLoginAndPassword())
                .then().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    //проверка создания дублирующего курьера
    @Test
    public void createDuplicateCourier() {
        courier.createNewCourier(CourierSettings.getAllCorrectCourierSettings());
        courier.createNewCourier(CourierSettings.getAllCorrectCourierSettings())
                .then().statusCode(409)
                .and()
                .assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }
}
