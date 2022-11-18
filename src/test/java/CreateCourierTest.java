import courier.Courier;
import courier.CourierClient;
import courier.CourierGenerator;
import courier.Creds;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class CreateCourierTest {
    private Courier courier;
    private CourierClient courierClient;
    private int id;

    @Before
    public void setUp() {
        courier = CourierGenerator.getDefault();
        courierClient = new CourierClient();
    }
    @After
    public void after() {
        courierClient.delete(courierClient.login(Creds.from(courier)).extract().path("id"));
    }

    @Test
    public void courierCanBeCreated() {
        ValidatableResponse createResponse = courierClient.create(courier);
        createResponse.statusCode(201).and().body("ok", equalTo(true));
    }
    @Test
    public void doubleCreation(){
        ValidatableResponse createResponse = courierClient.create(courier);
        ValidatableResponse doubleCreateResponse = courierClient.create(courier);
        createResponse.statusCode(201);
        doubleCreateResponse.statusCode(409).and().body("message",equalTo("Этот логин уже используется. Попробуйте другой."));
    }
    @Test
    public void login(){
        courierClient.create(courier).statusCode(201);
        ValidatableResponse loginResponse=courierClient.login(Creds.from(courier));
        loginResponse.statusCode(200);
        loginResponse.body("id",notNullValue());
    }
    @Test
    public void createCourierWihoutName() {
        courier = CourierGenerator.getNoName();
        ValidatableResponse response = courierClient.create(courier);
        response.statusCode(201).and().body("ok", equalTo(true));
    }




}