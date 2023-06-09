import org.apache.commons.lang3.RandomStringUtils;

public class OrderSettings {

    public static final String FIRST_NAME = RandomStringUtils.randomAlphanumeric(6);
    public static final String LAST_NAME = RandomStringUtils.randomAlphanumeric(5);
    public static final String ADDRESS = "Менделеева 18";
    public static final String METRO_STATION = "3";
    public static final String PHONE = "+7 950 55 25";
    public static final int RENT_TIME = 2;
    public static final String DELIVERY_DATE = "2023-06-04";
    public static final String COMMENT = "Лифт сломался";

    public static NewOrder createNewOrder(String[] color) {
        NewOrder newOrder = new NewOrder();
        newOrder.setFirstName(FIRST_NAME);
        newOrder.setLastName(LAST_NAME);
        newOrder.setAddress(ADDRESS);
        newOrder.setMetroStation(METRO_STATION);
        newOrder.setPhone(PHONE);
        newOrder.setRentTime(RENT_TIME);
        newOrder.setDeliveryDate(DELIVERY_DATE);
        newOrder.setComment(COMMENT);
        newOrder.setColor(color);
        return newOrder;
    }

}