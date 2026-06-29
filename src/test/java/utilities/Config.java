package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();
    static{
        try(InputStream fis = Config.class.getClassLoader().getResourceAsStream("config.properties")){
            if(fis!=null) props.load(fis);
        }
        catch (IOException e){
            throw new RuntimeException("FAILED TO LOAD CONFIG.PROPERTIES",e);
        }
    }

    public static String getBaseUrl(){
        return System.getProperty("baseUrl",props.getProperty("baseUrl"));
    }
    public static String getBrowser(){
        return System.getProperty("browser",props.getProperty("browser","chrome"));
    }
    public static boolean getHeadless(){
        return Boolean.parseBoolean(System.getProperty("headless",props.getProperty("headless","true")));
    }
    public static int getImplicitWaitTime(){
        return Integer.parseInt(System.getProperty("implicitWaitSec",props.getProperty("implicitWaitSec","10")));
    }
    public static int getExplicitWaitTime(){
        return Integer.parseInt(System.getProperty("explicitWaitSec",props.getProperty("explicitWaitSec","30")));
    }
}
