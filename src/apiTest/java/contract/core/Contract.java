package contract.core;

import java.util.HashMap;
import java.util.Map;

public final class Contract {

    private Request request;
    private Response response;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static final class Request {

        private String method;
        private String uri;

        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> pathParams = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();

        private Object payload = "";

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public void setHeaders(Map<String, String> headers) {
            this.headers = headers;
        }

        public Map<String, String> getPathParams() {
            return pathParams;
        }

        public void setPathParams(Map<String, String> pathParams) {
            this.pathParams = pathParams;
        }

        public Map<String, String> getQueryParams() {
            return queryParams;
        }

        public void setQueryParams(Map<String, String> queryParams) {
            this.queryParams = queryParams;
        }

        public Object getPayload() {
            return payload;
        }

        public void setPayload(Object payload) {
            this.payload = payload;
        }
    }

    public static final class Response {

        private Integer status;

        private Object payload;

        private Boolean strict = false;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Object getPayload() {
            return payload;
        }

        public void setPayload(Object payload) {
            this.payload = payload;
        }

        public Boolean getStrict() {
            return strict;
        }

        public void setStrict(Boolean strict) {
            this.strict = strict;
        }
    }
}
