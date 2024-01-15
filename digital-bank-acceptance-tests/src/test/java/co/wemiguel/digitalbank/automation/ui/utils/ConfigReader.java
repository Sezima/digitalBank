package co.wemiguel.digitalbank.automation.ui.utils;

//build a logic that reads the config file(properties file)


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private static Properties properties;

    //  static initializer run the block only once for the whole project
    //instance initializers run the block once for every object creation from the class
    static {
        // public static void main(String[] args) throws IOException {
        //filePath --> the directory of your properties file
        String filePath = "src/test/resources/properties/digitalbank.properties";

        //this is a class that enable you to read files
        //it throws a checked exceptions
        FileInputStream input = null;

        try {
            input = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(input);


        } catch (IOException e) {
            System.out.println("File not found");

        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



public static String getPropertiesValue(String key) {
    return properties.getProperty(key);
  }
}

//
//        System.out.println(properties.get("my_name"));
//        System.out.println(properties.get("browser"));
//        System.out.println(properties.get("environment"));


