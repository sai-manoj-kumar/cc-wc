package org.sai.ccwc.outputgenerator;

public class ErrorGenerator {
    public static String generateCommandError() {
        return "Command Format Error\nUsage: ccwc [-lcw] file";
    }

    public static String generateFileNotFoundError(String file) {
        return String.format("File Not Found: %s", file);
    }

    public static String generateReadError(String file) {
        return String.format("File Read Error: %s", file);
    }
}
