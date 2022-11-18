package courier;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CourierClient extends Client {
private static final String PATH = "/api/v1/courier/";
    public ValidatableResponse create(Courier courier){
        return given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post(PATH)
                .then();
    }
    public ValidatableResponse login(Creds creds){
        return given()
                .spec(getSpec())
                .body(creds)
                .when()
                .post(PATH+"login")
                .then();
    }
    public ValidatableResponse delete(int id){
        return given()
                .spec(getSpec())
                .body(new Id(id))
                .when()
                .delete(String.format("%s%d",PATH,id))
                .then();
    }
}
