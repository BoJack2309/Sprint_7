import org.apache.commons.lang3.RandomStringUtils;

public class CourierSettings {

    private static final String LOGIN = RandomStringUtils.randomAlphanumeric(10);
    private static final String PASSWORD = RandomStringUtils.randomAlphanumeric(10);
    private static final String FIRST_NAME = "BoJack";
    public static NewCourier getAllCorrectCourierSettings()
    {
        NewCourier newCourier = new NewCourier();
        newCourier.setLogin(LOGIN);
        newCourier.setPassword(PASSWORD);
        newCourier.setFirstName(FIRST_NAME);
        return newCourier;
    }
    public static NewCourier getCourierSettingsWithoutLogin()
    {
        NewCourier newCourier = new NewCourier();
        newCourier.setPassword(PASSWORD);
        newCourier.setFirstName(FIRST_NAME);
        return newCourier;
    }
    public static NewCourier getCourierSettingsWithoutPassword()
    {
        NewCourier newCourier = new NewCourier();
        newCourier.setLogin(LOGIN);
        newCourier.setFirstName(FIRST_NAME);
        return newCourier;
    }
    public static NewCourier getCourierSettingsWithoutLoginAndPassword()
    {
        NewCourier newCourier = new NewCourier();
        newCourier.setFirstName(FIRST_NAME);
        return newCourier;
    }
    public static NewCourier getCourierSettingsWithoutFirstName()
    {
        NewCourier newCourier = new NewCourier();
        newCourier.setLogin(LOGIN + "1");
        newCourier.setPassword(PASSWORD + "1");
        return newCourier;
    }

}
