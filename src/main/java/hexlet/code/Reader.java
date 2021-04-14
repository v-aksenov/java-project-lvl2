package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.SortedMap;

public class Reader {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static SortedMap<String, Object> readJson(String filepath) throws IOException {
        TypeReference<SortedMap<String, Object>> typeRef = new TypeReference<>() {
        };
        return MAPPER.readValue(new File(filepath), typeRef);
    }
}
