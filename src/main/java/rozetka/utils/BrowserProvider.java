package rozetka.utils;

import java.util.Map;

public class BrowserProvider {

    public static String getBrowser() {

        Map<String, String> map = PropertyResolver.getResource("project.properties");
        String browser = map.get("browser");
        return browser;
    }
}
