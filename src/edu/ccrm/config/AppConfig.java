package edu.ccrm.config;

public class AppConfig {
    private static AppConfig instance;
    private String appVersion = "1.0.0";
    private String dataPath = "data";

    private AppConfig() {
        // Private constructor prevents instantiation from other classes
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getDataPath() {
        return dataPath;
    }
}