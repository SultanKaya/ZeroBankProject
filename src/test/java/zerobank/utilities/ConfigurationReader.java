package zerobank.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    //This class will be used to load the configuration data from the properties file.
    // Will provide access to values based on key names

    private static Properties configFile;
    private static FileInputStream fileInputStream;
    static {
        try {

            /*
                    provides access to file
                    handling potential exception
                    if exception occcurs code inside the catch block will be executed
             */
            fileInputStream = new FileInputStream("configuration.properties");

            configFile = new Properties();
            configFile.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Properties File was not loaded");
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }


}
