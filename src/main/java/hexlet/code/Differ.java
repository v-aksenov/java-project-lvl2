package hexlet.code;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class Differ {

    public final String generate(String filePath1, String filePath2) throws IOException {
        final SortedMap<String, Object> map1 = Parser.readJson(filePath1);
        final SortedMap<String, Object> map2 = Parser.readJson(filePath2);
        return "{\n" + getDiff(map1, map2) + "}";
    }

    private String getDiff(SortedMap<String, Object> fields1, SortedMap<String, Object> fields2) {
        final StringBuilder sb = new StringBuilder();
        final HashSet<String> allKeys = new HashSet<>(fields1.keySet());
        allKeys.addAll(fields2.keySet());
        final List<String> sorted = allKeys.stream().sorted().collect(Collectors.toList());
        final Iterator<String> iterator = sorted.iterator();
        while (iterator.hasNext()) {
            final String next = iterator.next();
            final Object next1 = fields1.get(next);
            final Object next2 = fields2.get(next);
            String template = "  %s %s: %s\n";
            if (next2 != null) {
                if (next1 != null) {
                    if (!Objects.equals(next2, next1)) {
                        sb.append(template.formatted("-", next, next1));
                        sb.append(template.formatted("+", next, next2));
                    } else {
                        sb.append(template.formatted(" ", next, next1));
                    }
                } else {
                    sb.append(template.formatted("+", next, next2));
                }
            } else {
                if (next1 != null) {
                    sb.append(template.formatted("-", next, next1));
                }
            }
        }
        return sb.toString();
    }
}
