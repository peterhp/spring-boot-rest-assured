package contract.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public final class ResLoader {
    public static String loadString(String resFile) throws IOException {
        return IOUtils.toString(ClassLoader.getSystemResourceAsStream(resFile), "UTF-8");
    }

    public static <T> T loadJson(String jsonFile, Class<T> type) throws IOException {
        return JsonUtils.fromJsonString(loadString(jsonFile), type);
    }
}
