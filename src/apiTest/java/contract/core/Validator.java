package contract.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import contract.utils.JsonUtils;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;

import static java.util.Objects.nonNull;
import static org.hamcrest.Matchers.is;

public final class Validator {

    public static void validateResponse(Contract.Response expected, Response actual) throws Exception {
        validateInteger(expected.getStatus(), actual.getStatusCode());

        boolean strictMode = nonNull(expected.getStrict()) ? expected.getStrict() : false;
        validateJson(expected.getPayload(), actual.getBody().asString(), strictMode);
    }

    public static void validateInteger(Integer expected, Integer actual) {
        if (nonNull(expected)) {
            Assert.assertThat(actual, is(expected));
        }
    }

    public static void validateJsonString(String expected, String actual, boolean strict) throws JSONException {
        if (nonNull(expected)) {
            JSONAssert.assertEquals(expected, actual, strict);
        }
    }

    public static void validateJsonObject(Object expected, Object actual, boolean strict)
            throws JSONException, JsonProcessingException {
        if (nonNull(expected)) {
            String expectedString = JsonUtils.toJsonString(expected);
            String actualString = JsonUtils.toJsonString(actual);
            JSONAssert.assertEquals(expectedString, actualString, strict);
        }
    }

    public static void validateJson(Object expected, String actual, boolean strict)
            throws JsonProcessingException, JSONException {
        if (nonNull(expected)) {
            JSONAssert.assertEquals(JsonUtils.toJsonString(expected), actual, strict);
        }
    }
}
