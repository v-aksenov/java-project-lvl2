package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.SortedMap;

public class Parser {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());

    public static SortedMap<String, Object> readJson(String filepath) throws IOException {
        TypeReference<SortedMap<String, Object>> typeRef = new TypeReference<>() {
        };
        if (filepath.endsWith("yml")) {
            return YAML_MAPPER.readValue(new File(filepath), typeRef);
        }
        return MAPPER.readValue(new File(filepath), typeRef);
    }
}
