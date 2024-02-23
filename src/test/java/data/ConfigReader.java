package data;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {/*
no use
    static Properties properties = new Properties();

    public static String getProperty(String param) {
        if (properties.toString().equals("{}")) {//singleton - if it is null call method
            initProperty();
        }
        ;
        return properties.getProperty(param);//if it is not null do nothing
    }

    private static void initProperty() {
        try (FileReader fileReader = new FileReader("src/test/resources/config.properties")) {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
