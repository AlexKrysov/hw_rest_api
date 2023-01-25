package com.krysov.demoWebShopTests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;

public class TestsHW18 {
    String cookieValue = "0B7E2440DA0113183F94928F4F9226C4D9D9158080EE0A2C67705BA586A922" +
            "E8599AB4412418CB0775559FA73573380AA8CC5C455F5EDE4C92DCCD05605D5213621BDEF00" +
            "D0DADEE1908731F78804A4B3541F852503CC45C348FF0501848F146A5A282EA9798A1639BCF" +
            "E882FA2ED26E5A449E3BAD318808383677A1DF072C4642540A0262946048BC60119B1715BABC";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }

    @Test
    void  addLaptopToCertTest(){
        given()
                .cookie("NOPCOMMERCE.AUTH",cookieValue)
                .when()
                .post("/addproducttocart/catalog/31/1/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }
    @Test
    void  addComputerToCertTest(){
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH",cookieValue)
                .body("product_attribute_74_5_26=81&product_attribute_74_6_27=83&product_attribute_74_3_28=86&" +
                        "product_attribute_74_8_29=89&addtocart_74.EnteredQuantity=1")
                .when()
                .post("/addproducttocart/details/74/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }
    @Test
    void  addGiftCardToCertTest(){
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH",cookieValue)
                .body("giftcard_1.RecipientName=alex&giftcard_1.RecipientEmail=krysov-95%40mail.ru&giftcard_1" +
                        ".SenderName=alex&giftcard_1.SenderEmail=krysov-95%40mail.ru&giftcard_1.Message=hi+qa" +
                        "+guru&addtocart_1.EnteredQuantity=1")
                .when()
                .post("/addproducttocart/details/1/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }
    @Test
    void  changeNameAndEmailForGiftCardTest(){
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH",cookieValue)
                .body("giftcard_1.RecipientName=alex3&giftcard_1.RecipientEmail=krysov-95%40mail.ru&giftcard_1" +
                        ".SenderName=Yana&giftcard_1.SenderEmail=yana-99%40mail.ru&giftcard_1.Message=hi+qa+gu" +
                        "ru&addtocart_1.UpdatedShoppingCartItemId=2975099&addtocart_1.EnteredQuantity=6")
                .when()
                .post("/addproducttocart/details/1/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }
}
