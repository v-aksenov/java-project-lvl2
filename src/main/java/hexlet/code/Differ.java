package hexlet.code;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class Differ {

    private final static ObjectMapper mapper = new ObjectMapper();

    public String generate(String filePath1, String filePath2) throws IOException {
        final Iterator<Map.Entry<String, JsonNode>> fields1 = Reader.readJson(filePath1).fields();
        final Iterator<Map.Entry<String, JsonNode>> fields2 = Reader.readJson(filePath2).fields();
        return START + getDiff(fields1, fields2) + END;
    }

    private String getDiff(Iterator<Map.Entry<String, JsonNode>> fields1,
                           Iterator<Map.Entry<String, JsonNode>> fields2) {
        final StringBuilder sb = new StringBuilder();
        while (fields1.hasNext() || fields2.hasNext()) {
            final Map.Entry<String, JsonNode> next1 = fields1.hasNext() ? fields1.next() : null;
            final Map.Entry<String, JsonNode> next2 = fields2.hasNext() ? fields2.next() : null;
            sb.append(getResult(next1, next2));
        }
        return sb.toString();
    }

    private String getResult(Map.Entry<String, JsonNode> next1, Map.Entry<String, JsonNode> next2) {
        if(next1 == null) {
            return TEMPLATE.formatted("+", next2.getKey(), next2.getValue().asText());
        }

        if(next2 == null) {
            return TEMPLATE.formatted("-", next1.getKey(), next1.getValue().asText());
        }

        if(next1.equals(next2)) {
            return TEMPLATE.formatted(" ", next1.getKey(), next1.getValue().asText());
        } else {
            return TEMPLATE.formatted("-", next1.getKey(), next1.getValue().asText())
                    + TEMPLATE.formatted("+", next2.getKey(), next2.getValue().asText());
        }
    }

    private final static String START = "{\n";
    private final static String END = "}";
    private final static String TEMPLATE = "  %s %s: %s\n";
}
