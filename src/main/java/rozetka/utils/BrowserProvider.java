package rozetka.utils;

import java.util.Map;

public class BrowserProvider {

    public static String getBrowser() {

        Map<String, String> map = PropertyResolver.getResource("project.properties");
        return map.get("browser");
    }
}
