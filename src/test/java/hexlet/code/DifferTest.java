package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    public static final String EXPECT = """
            {
                common: {
                  + follow: false
                    setting1: Value 1
                  - setting2: 200
                  - setting3: true
                  + setting3: null
                  + setting4: blah blah
                  + setting5: {
                        key5: value5
                    }
                    setting6: {
                        doge: {
                          - wow:
                          + wow: so much
                        }
                        key: value
                      + ops: vops
                    }
                }
                group1: {
                  - baz: bas
                  + baz: bars
                    foo: bar
                  - nest: {
                        key: value
                    }
                  + nest: str
                }
              - group2: {
                    abc: 12345
                    deep: {
                        id: 45
                    }
                }
              + group3: {
                    deep: {
                        id: {
                            number: 45
                        }
                    }
                    fee: 100500
                }
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
