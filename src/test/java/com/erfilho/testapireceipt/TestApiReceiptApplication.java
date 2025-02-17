package com.erfilho.testapireceipt;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestApiReceiptApplication {
    @BeforeClass
    public static void setup(){
        String port = System.getProperty("server.port");
        if(port == null){
            RestAssured.port = Integer.valueOf(8080);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if(basePath == null){
            basePath = "/receipts";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost == null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
    }
}

