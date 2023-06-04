import org.apache.commons.lang3.RandomStringUtils;

public class LoginSettings {

    private static final String LOGIN = RandomStringUtils.randomAlphanumeric(10);
    private static final String PASSWORD = RandomStringUtils.randomAlphanumeric(10);

    public static CourierLogin correctLogin(NewCourier newCourier) {
        CourierLogin courierLogin = new CourierLogin();
        courierLogin.setLogin(newCourier.getLogin());
        courierLogin.setPassword(newCourier.getPassword());
        return courierLogin;
    }
    public static CourierLogin incorrectLogin() {
        CourierLogin courierLogin = new CourierLogin();
        courierLogin.setLogin(LOGIN);
        courierLogin.setPassword(PASSWORD);
        return courierLogin;
    }
    public static CourierLogin withoutLogin() {
        CourierLogin courierLogin = new CourierLogin();
        courierLogin.setPassword(PASSWORD);
        return courierLogin;
    }
}