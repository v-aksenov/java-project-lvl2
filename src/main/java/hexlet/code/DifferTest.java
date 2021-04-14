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
    void generate() throws IOException {
        final String generate = new Differ().generate("file1.json", "file2.json");
        assertEquals(EXPECT, generate);
    }
}