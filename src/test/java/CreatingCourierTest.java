import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class CreatingCourierTest {

    NewCourier newCourier;
    CourierClient courierClient;

    @Before
    public void setup() {
        newCourier = NewCourier.getAllCorrectCourierSettings(); //
        courierClient = new CourierClient();
    }

    /*
    @Test
    @DisplayName("Создание курьера с корректными значениями полей")
    public void createCourierWithCorrectSettings() {
        courierClient.createNewCourier(CourierSettings.getAllCorrectCourierSettings())
                .then().statusCode(201)
                .and()
                .assertThat().body("ok", equalTo(true));
    }*/

    @Test
    @DisplayName("Создание курьера с корректными значениями полей")
    public void createCourierWithCorrectSettings() {
        Response correctCourier = courierClient.createNewCourier(CourierSettings.getAllCorrectCourierSettings());
        correctCourier.then().statusCode(201).and().assertThat().body("ok", equalTo(true));
    }

    /*
    @Test
    @DisplayName("Создание курьера с корректными значениями полей без указания имени")
    public void createCourierWithCorrectSettingsWithoutFirstName() {
        courierClient.createNewCourier(CourierSettings.getCourierSettingsWithoutFirstName())

                .then().statusCode(201)
                .and()
                .assertThat().body("ok", equalTo(true));
    }*/

    @Test
    @DisplayName("Создание курьера с корректными значениями полей без указания имени")
    public void createCourierWithCorrectSettingsWithoutFirstName() {
        Response withoutFirstName = courierClient.createNewCourier(CourierSettings.getCourierSettingsWithoutFirstName());
        withoutFirstName.then().statusCode(201).and().assertThat().body("ok", equalTo(true));
    }

    /*
    @Test
    @DisplayName("Создание курьера без указания пароля")
    public void createCourierWithoutPassword(){
        courierClient.getIncorrectCourier(CourierSettings.getCourierSettingsWithoutPassword())
                .then().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }*/

    @Test
    @DisplayName("Создание курьера без указания пароля")
    public void createCourierWithoutPassword(){
        Response withoutPassword = courierClient.getIncorrectCourier(CourierSettings.getCourierSettingsWithoutPassword());
        withoutPassword.then().statusCode(400).and().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    /*
    @Test
    @DisplayName("Создание курьера без указания логина")
    public void createCourierWithoutLogin() {
        courierClient.getIncorrectCourier(CourierSettings.getCourierSettingsWithoutLogin())
                .then().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }*/

    @Test
    @DisplayName("Создание курьера без указания логина")
    public void createCourierWithoutLogin() {
        Response withoutLogin = courierClient.getIncorrectCourier(CourierSettings.getCourierSettingsWithoutLogin());
        withoutLogin.then().statusCode(400).and().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    /*
    @Test
    @DisplayName("Создание курьера без указания логина и пароля")
    public void createCourierWithoutLoginAndPassword(){
        courierClient.getIncorrectCourier(CourierSettings.getCourierSettingsWithoutLoginAndPassword())
                .then().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }*/


    @Test
    @DisplayName("Создание курьера без указания логина и пароля")
    public void createCourierWithoutLoginAndPassword() {
        Response incorrectCourier = courierClient.getIncorrectCourier(CourierSettings.getCourierSettingsWithoutLoginAndPassword());
        incorrectCourier.then().statusCode(400).and().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    /*
    @Test
    @DisplayName("Создание дублирующего курьера")
    public void createDuplicateCourier() {
        courierClient.createNewCourier(CourierSettings.getAllCorrectCourierSettings());
        courierClient.createNewCourier(CourierSettings.getAllCorrectCourierSettings())
                .then().statusCode(409)
                .and()
                .assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    } */

    @Test
    @DisplayName("Создание дублирующего курьера")
    public void creatingDuplicateCourier() {
        courierClient.createNewCourier(CourierSettings.getAllCorrectCourierSettings());
        Response duplicate = courierClient.createNewCourier(CourierSettings.getAllCorrectCourierSettings());
        duplicate.then().statusCode(409)
                .and().assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }
}
