package helpers;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetUrl {
    private static Logger logger = LogManager.getLogger(GetUrl.class);

    public static void writeCurrentUrlInFile(WebDriver driver) {
        String url = driver.getCurrentUrl();
        Path urlPath = Paths.get("temp\\url.txt");
        try {
            Files.writeString(urlPath, url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrlFromFile() {
        Path urlPath = Paths.get("temp\\url.txt");
        String url = null;
        try {
            url = new String(Files.readAllBytes(urlPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}
