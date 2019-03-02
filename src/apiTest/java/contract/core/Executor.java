package contract.core;

import contract.utils.JsonUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public final class Executor {

    public static void execute(String contract) throws Exception {
        execute(JsonUtils.fromJsonString(contract, Contract.class));
    }

    public static void execute(Contract contract) throws Exception {
        Response response = send(contract.getRequest());
        Validator.validateResponse(contract.getResponse(), response);
    }

    public static Response send(Contract.Request request) {
        return given()
                .headers(request.getHeaders())
                .pathParams(request.getPathParams())
                .queryParams(request.getQueryParams())
                .contentType(ContentType.JSON)
                .body(request.getPayload())
                .accept(ContentType.JSON)
                .when()
                .request(request.getMethod(), request.getUri())
                .thenReturn();
    }
}
