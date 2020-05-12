package io.quarkus.qe.undertow;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UNDERTOW_1657_1671_Test {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void test() {
        String message = "POST /path HTTP/1.1\r\n" +
                                "Expect: 100-continue\r\n" +
                                "Content-Length: 16\r\n" +
                                "Content-Type: text/plain; charset=ISO-8859-1\r\n" +
                                "Host: localhost:7777\r\n" +
                                "Connection: Keep-Alive\r\n\r\nMy HTTP Request!";


    }

}