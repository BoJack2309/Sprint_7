import org.apache.commons.lang3.RandomStringUtils;

public class NewCourier {

    private String login;
    private String password;
    private String firstName;

    private static final String LOGIN = RandomStringUtils.randomAlphanumeric(10);
    private static final String PASSWORD = RandomStringUtils.randomAlphanumeric(10);
    private static final String FIRST_NAME = "BoJack";

    public NewCourier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }
    public NewCourier() {

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

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static NewCourier getAllCorrectCourierSettings()
    {
        NewCourier newCourier = new NewCourier();
        newCourier.setLogin(LOGIN);
        newCourier.setPassword(PASSWORD);
        newCourier.setFirstName(FIRST_NAME);
        return newCourier;
    }
    //
}