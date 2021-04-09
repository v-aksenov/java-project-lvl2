package hexlet.code;

import com.fasterxml.jackson.core.TreeNode;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @CommandLine.Parameters(description = "path to first file")
    private String filepath1;

    @CommandLine.Parameters(description = "path to second file")
    private String filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    public static void main(final String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        final TreeNode treeNode1 = Reader.readJson(filepath1);
        final TreeNode treeNode2 = Reader.readJson(filepath2);
        System.out.println(treeNode1);
        System.out.println(treeNode2);
        return 0;
    }
}
