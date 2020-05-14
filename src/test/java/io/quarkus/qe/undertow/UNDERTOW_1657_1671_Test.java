package io.quarkus.qe.undertow;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class UNDERTOW_1657_1671_Test {

    @Test
    public void testHelloEndpoint() {
        for (int i = 0; i < 1000; i++) {
            Response response = given()
                //.header("User-Agent","HTTP/1.1").and()
                .header("Expect","100-continue").and()
                //.header("Content-Length", 16).and()
                .header("Connection","Keep-Alive").and()
                .header("Content-Type","text/xml; charset=UTF-8")
                .when()
                .get("/hello");
            response.then()
                .statusCode(417);
                //.body(containsString("hi everyone!"));
            System.out.println("Aktualni cislo: " + i);
        }
    }

    @Test
    public void testParsePathParam() {
        //HttpServerExchange exchange = new HttpServerExchange()
        //URLUtils.parsePathParams("/hello", );

        /*Response response = given()
                .when()
                .post("/hello")
                .andReturn();
        response.then()
                .*/
    }
}