package property;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    static Properties properties = new Properties();
    public static String getProperty(String parameters){
        if(parameters.toString().equals("{}")){
            initProperty();
        }
        return properties.getProperty(parameters);
    }

    private static void initProperty() {
        //Initialization property from file by link src/test/resources/%s.properties
        String target = System.getProperty("target", "login");
        String path = String.format("src/test/resources/%s.properties", target);
        //target will be or production or stage according file in resource
        try(FileReader fileReader = new FileReader(path)) {
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
