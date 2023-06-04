import org.apache.commons.lang3.RandomStringUtils;

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

    public static CourierLogin getLoginRequestAllRequiredField(NewCourier newCourier)
    {
        CourierLogin courierLogin = new CourierLogin();
        courierLogin.setLogin(newCourier.getLogin());
        courierLogin.setPassword(newCourier.getPassword());
        return courierLogin;
    }
}
