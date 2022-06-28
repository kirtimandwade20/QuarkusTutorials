package com.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class ProductResourceTest {

    @Test
    public void testProductGetAll() {
        given()
          .when().get("/product")   
          .then().assertThat()
             .statusCode(200).body("size()", is(5));

    }

    @Test
    public void testProductFind() {
        given()
          .when().get("/product/find?name=Blackberry")   
          .then().assertThat()
             .statusCode(200);

    }
}