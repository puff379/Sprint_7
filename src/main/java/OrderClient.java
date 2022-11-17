import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderClient extends Client{
    private static final String PATH = "/api/v1/orders";
    public ValidatableResponse create(Order order){
        return given()
                .spec(getSpec())
                .body(order)
                .when()
                .post(PATH)
                .then();
    }
    public ValidatableResponse getOrdersList() {
        return given()
                .spec(getSpec())
                .when()
                .get(PATH)
                .then()
                .log().all();
    }
}

