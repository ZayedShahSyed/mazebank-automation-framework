package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class DriverFactory {

    private DriverFactory() {}

    public static WebDriver createDriver(String browser,boolean headless) {
        return switch(browser.toLowerCase()){
            case "chrome" -> createChrome(headless);
            case "firefox" -> createFirefox(headless);
            case "edge" -> createEdge(headless);
            default -> throw new IllegalArgumentException(browser + " Browser Not Supported");
        };
    }

    public static RemoteWebDriver createChrome(boolean headless){
        ChromeOptions opts = new ChromeOptions();
        if(headless){
            opts.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage");

            opts.addArguments("--disable-popup-blocking");

        }
        return new ChromeDriver(opts);
    }

    public static RemoteWebDriver createFirefox(boolean headless){
        FirefoxOptions opts = new FirefoxOptions();
        if(headless){
            opts.addArguments("--headless");
        }
        return new FirefoxDriver(opts);
    }

    public static RemoteWebDriver createEdge(boolean headless){
        EdgeOptions opts = new EdgeOptions();
        if(headless) opts.addArguments("--headless=new");
        return new EdgeDriver(opts);
    }
}