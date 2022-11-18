package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Client {
    private static final String BASEIRL="http://qa-scooter.praktikum-services.ru";
    protected RequestSpecification getSpec(){
      return new RequestSpecBuilder()
              .setContentType(ContentType.JSON)
              .setBaseUri(BASEIRL).build();

    }
}
