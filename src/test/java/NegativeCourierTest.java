import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;


public class NegativeCourierTest {
    private Courier courier;
    private CourierClient courierClient;
    private int id;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
        courier = CourierGenerator.getDefault();
    }
    @Test
    public void createCourierWihoutLogin() {
        ValidatableResponse response = courierClient.create(Courier.builder().password("123").firstName("Вася").build());
        response.statusCode(400).and().body("message",equalTo("Недостаточно данных для создания учетной записи"));
    }
    @Test
    public void createCourierWihoutPassword() {
        ValidatableResponse response = courierClient.create(Courier.builder().login("Vasya").firstName("Вася").build());
        response.statusCode(400).and().body("message",equalTo("Недостаточно данных для создания учетной записи"));
    }
    @Test
    public void loginCourierWihoutLogin() {
        courierClient.create(courier);
        courierClient.login(Creds.noLogin(courier)).statusCode(400).and().body("message",equalTo("Недостаточно данных для входа"));
    }
    @Test
    public void loginCourierWihoutPassword() {
     //   courierClient.create(courier);
        courierClient.login(Creds.noPassword(courier)).statusCode(400).and().body("message",equalTo("Недостаточно данных для входа"));
    }
    @Test
    public void unknownCourier(){
        courierClient.login(Creds.builder().login("usermuser").password("passmass").build()).statusCode(404).and().body("message",equalTo("Учетная запись не найдена"));
    }
}
