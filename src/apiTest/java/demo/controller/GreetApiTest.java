package demo.controller;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetApiTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost/api";
        RestAssured.port = port;
    }

    @Test
    public void shouldSayHelloToPerson() throws Exception {
        RestAssured
                .given()
                .queryParam("person", "Sora")
                .when()
                .get("/greet")
                .then()
                .assertThat()
                .statusCode(200)
                .body(equalTo("Hello, Sora!"));
    }

    @Test
    public void shouldSayHelloToStranger() throws Exception {
        RestAssured
                .given()
                .when()
                .get("/greet")
                .then()
                .assertThat()
                .statusCode(200)
                .body(equalTo("Hello, Stranger!"));
    }
}