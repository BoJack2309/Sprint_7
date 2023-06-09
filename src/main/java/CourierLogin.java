import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

import static io.restassured.RestAssured.given;

public class CourierLogin {
    private String login;
    private String password;

    public CourierLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    public CourierLogin() {
        
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private static final String LOGIN = RandomStringUtils.randomAlphanumeric(10);
    private static final String PASSWORD = RandomStringUtils.randomAlphanumeric(10);

    @Step("Все заполненные поля")
    public static CourierLogin getLoginRequestAllRequiredField(NewCourier newCourier)
    {
        CourierLogin courierLogin = new CourierLogin();
        courierLogin.setLogin(newCourier.getLogin());
        courierLogin.setPassword(newCourier.getPassword());
        return courierLogin;
    }

    @Step("Авторизация с корректными значениями")
    public Response authWithCorrectsSettings() {
        NewCourier newCourier = CourierSettings.getAllCorrectCourierSettings();
        given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(newCourier)
                .post(Constants.COURIER);

        return given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(CourierSettings.getAllCorrectCourierSettings())
                .post(Constants.COURIER_LOGIN);
    }

    @Step("Авторизация без логина")
    public Response AuthorisationWithoutLogin() {
        return given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(LoginSettings.withoutLogin())
                .post(Constants.COURIER_LOGIN);
    }

    @Step("Авторизация с некорректным логином")
    public Response AuthorisationWithIncorrectLogin() {
        return given()
                .header("Content-type", "application/json")
                .baseUri(Constants.getBaseUrl())
                .body(LoginSettings.incorrectLogin())
                .post(Constants.COURIER_LOGIN);
    }
}