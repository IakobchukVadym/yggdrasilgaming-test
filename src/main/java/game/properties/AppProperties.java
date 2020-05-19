package game.properties;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

public class AppProperties {

    private static final String ENVIRONMENT = StringUtils.defaultIfEmpty(System.getProperty("env"), "test");
    private static final String APP_PROPERTIES_PATH = "config/" + ENVIRONMENT + "/app.properties";
    private static final Properties properties = LoadProperties.load(APP_PROPERTIES_PATH);
    public static final String BASE_URL = properties.getProperty("url");
    public static final String GAME_SERVICE_URL = properties.getProperty("game_service");
    public static final String ORGANIZATION = properties.getProperty("organization");
    public static final String VIKINGS_GAME_ID = properties.getProperty("vikings_game_id");

    private AppProperties() {
    }
}
