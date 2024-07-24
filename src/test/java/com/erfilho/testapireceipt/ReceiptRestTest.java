package com.erfilho.testapireceipt;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ReceiptRestTest extends TestApiReceiptApplication {
    @Test
    public void testIsOnline(){
        given().when().get("/").then().statusCode(200);
    }

    @Test
    public void testReceiptNotFound(){
        given().when().get("/999").then().statusCode(404);
    }

    @Test
    public void testReceiptInsertion(){
        Map<String, String> receipt = new HashMap<>();
        receipt.put("tipo", "Crédito");
        receipt.put("valor", String.valueOf(21.99));

        given()
                .contentType("application/json")
                .body(receipt)
                .when().post("/").then()
                .statusCode(201);
    }

    @Test
    public void testReceiptExists(){
        given().when().get("/1").then()
                .body("tipo", equalTo("Crédito"))
                .body("valor", equalTo(21.99F))
                .statusCode(200);
    }
}
