package contract.core;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public final class Contract {

    private Request request;
    private Response response;

    @Data
    public static final class Request {

        private String method;
        private String uri;

        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> pathParams = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();

        private Object payload = "";
    }

    @Data
    public static final class Response {

        private Integer status;

        private Object payload;

        private Boolean strict = false;
    }
}
