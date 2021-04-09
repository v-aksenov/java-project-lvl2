package hexlet.code;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Reader {
    public static TreeNode readJson(String filepath) throws IOException {
        return new ObjectMapper().readTree(new File(filepath));
    }
}
