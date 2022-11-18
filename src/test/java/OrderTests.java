import io.restassured.response.ValidatableResponse;
import order.Order;
import order.OrderClient;
import order.OrderGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderTests {

    Order order;

    public OrderTests(Order order) {
        this.order = order;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {OrderGenerator.getGreyBike()},
                {OrderGenerator.getBlackBike()},
                {OrderGenerator.getGreyBlackBike()},
                {OrderGenerator.getDefaultDataWithoutColour()}
        };
    }
    @Test
    public void selectColour () {
        OrderClient client = new OrderClient();
        ValidatableResponse response = client.create(order);
        response.statusCode(201).and().body("track",notNullValue());
    }
}
