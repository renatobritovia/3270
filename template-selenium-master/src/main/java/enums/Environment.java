package enums;

public enum Environment {
    DEFAULT("configuration.yml");

    private final String filePath;

    Environment(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
