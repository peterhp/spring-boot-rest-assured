package contract.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public final class JsonUtils {
    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static ObjectMapper getMapper() {
        return MAPPER;
    }

    public static <T> T fromJsonString(String json, Class<T> type) throws IOException {
        return MAPPER.readValue(json, type);
    }

    public static <T> String toJsonString(T obj) throws JsonProcessingException {
        return MAPPER.writeValueAsString(obj);
    }
}
