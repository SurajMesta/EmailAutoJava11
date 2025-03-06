package Utils;

import java.io.FileInputStream;
import java.util.*;

public final class PropertyUtils {

    private PropertyUtils() {
    }

    private static Properties properties = new Properties();
    private static Map<String, String> map = new HashMap<>();

    static {
        try (FileInputStream fis = new FileInputStream(FilePaths.getConifgProperties())) {
            properties.load(fis);
            properties.entrySet().forEach(e -> map.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key) {
        return map.get(key.toUpperCase());
    }

}
