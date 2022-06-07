package environment;


import enums.Environment;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class PropertyLoader {

    private PropertyLoader() {
    }

    public static PropertyLoader get() {
        return new PropertyLoader();
    }

    public String getExecution(Environment environment) {

        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getFilePath()));

        Map<String, Object> envenvironmenTag = (Map<String, Object>) root.get("environment");
        return envenvironmenTag.get("execution").toString();
    }

    public String getBrowser(Environment environment) {

        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getFilePath()));

        Map<String, Object> envenvironmenTag = (Map<String, Object>) root.get("environment");
        return envenvironmenTag.get("browser").toString();
    }




}
