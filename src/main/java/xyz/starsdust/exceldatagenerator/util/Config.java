package xyz.starsdust.exceldatagenerator.util;

import com.google.gson.Gson;
import xyz.starsdust.exceldatagenerator.pojo.ConfigType;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Config {
    private static Config instance;
    private ConfigType configType;

    private Config() {

    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }

    public ConfigType getConfig() {
        return this.configType;
    }

    public void loadConfig(String configFilePath) {
        // 解析配置文件
        Gson gson = new Gson();
        String jsonString = getFileString(configFilePath);
        this.configType = gson.fromJson(jsonString, ConfigType.class);
    }

    private String getFileString(String configFilePath) {
        String fileContent;

        try {
            String path = new File("").getCanonicalFile() + configFilePath;
            fileContent = Files.readString(Paths.get(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return fileContent;
    }
}
