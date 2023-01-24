package com.krysov.demoWebShopTests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;

public class TestsHW18 {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }

    @Test
    void  addToCertTest(){
        given()
                .cookie("NOPCOMMERCE.AUTH","0B7E2440DA0113183F94928F4F9226C4D9D9158080EE0A2C67705BA586A922" +
                        "E8599AB4412418CB0775559FA73573380AA8CC5C455F5EDE4C92DCCD05605D5213621BDEF00D0DADEE1908731F78804A4B354" +
                        "1F852503CC45C348FF0501848F146A5A282EA9798A1639BCFE882FA2ED26E5A449E3BAD318808383677A1DF072C4642540A0262946048BC60119B1715BABC")
                .when()
                .post("/addproducttocart/catalog/31/1/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }
}
