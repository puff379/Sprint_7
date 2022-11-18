import io.restassured.response.ValidatableResponse;
import order.OrderClient;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetOrderListTest {
    @Test

    public void getOrderListTest() {
        OrderClient order = new OrderClient();
        ValidatableResponse orderListResponse = order.getOrdersList().statusCode(200);
        orderListResponse.assertThat().body("orders.id", notNullValue());
    }
}
