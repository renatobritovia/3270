package environment;

import enums.Environment;
import org.apache.commons.lang3.StringUtils;

import static enums.Environment.DEFAULT;

public abstract class CurrentEnvironmentLoader {

    private CurrentEnvironmentLoader(){}

    public static Environment get() {
        String env = System.getProperty("env");
        if (StringUtils.isEmpty(env)) {
            return DEFAULT;
        }
        switch (env) {
            default:
                return DEFAULT;
        }
    }

}
