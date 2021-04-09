package hexlet.code;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Reader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode readJson(String filepath) throws IOException {
        return mapper.readTree(new File(filepath));
    }
}
