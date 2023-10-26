package org.example;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static Path asResourcePath(String resourcePath){
        URL url = ClassLoader.getSystemResource(resourcePath);
        if (url == null) {
            throw new IllegalArgumentException(String.format("Cannot find the '%s' resource", resourcePath));
        }
        return Paths.get(url.getPath());
    }
}
