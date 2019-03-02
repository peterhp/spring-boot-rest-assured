package demo.config;

import io.restassured.RestAssured;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class SpringBootTestConfig {

    public SpringBootTestConfig() {
        configRestAssured();
    }

    private void configRestAssured() {
        RestAssured.baseURI = "https://localhost";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
        RestAssured.requestSpecification = given();
        RestAssured.useRelaxedHTTPSValidation();
    }
}
