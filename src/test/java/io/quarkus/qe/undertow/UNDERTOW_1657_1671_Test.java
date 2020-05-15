package io.quarkus.qe.undertow;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.ParameterLimitException;
import io.undertow.util.URLUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UNDERTOW_1657_1671_Test {

    @Test
    public void testHelloEndpoint() {
        for (int i = 0; i < 10; i++) {
            Response response = given()
                .header("User-Agent","HTTP/1.1").and()
                .header("Expect","100-continue").and()
                .header("Content-Length", 16).and()
                .header("Connection","Keep-Alive").and()
                .header("Content-Type","text/xml; charset=UTF-8")
                .when()
                .get("/hello");
            response.then()
                .statusCode(417);
            System.out.println("Aktualni cislo: " + i);
        }
    }

    @Test
    public void testParsePathParam() throws ParameterLimitException {
        String s = "p=" + "/hello&everyone;everybody";
        HttpServerExchange exchange = new HttpServerExchange(new MockHttpExchange(),-1 );
        URLUtils.parsePathParams(s, exchange, "UTF_8", true, 1000);

        Assertions.assertEquals("/hello&everyone", exchange.getPathParameters().get("p").getFirst());
    }
}