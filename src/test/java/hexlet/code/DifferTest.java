package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    public static final String EXPECT = """
            {
              - follow: false
                host: hexlet.io
              - proxy: 123.234.53.22
              - timeout: 50
              + timeout: 20
              + verbose: true
            }""";

    @Test
    void generateJsonDIff() throws IOException {
        final String generate = new Differ().generate("src/test/resources/file1.json", "src/test/resources/file2.json");
        assertEquals(EXPECT, generate);
    }

    @Test
    void generateYmlDIff() throws IOException {
        final String generate = new Differ().generate("src/test/resources/file1.yml", "src/test/resources/file2.yml");
        assertEquals(EXPECT, generate);
    }
}
