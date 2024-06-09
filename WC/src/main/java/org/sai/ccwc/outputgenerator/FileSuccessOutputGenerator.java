package org.sai.ccwc.outputgenerator;

import org.sai.ccwc.WordCountOption;

import java.util.ArrayList;

public class FileSuccessOutputGenerator {
    private final String file;
    long lineCount = -1;
    long wordCount = -1;
    long byteCount = -1;

    public FileSuccessOutputGenerator(String file) {
        this.file = file;
    }

    public void setCount(WordCountOption option, long count) {
        switch (option) {
            case line -> lineCount = count;
            case word -> wordCount = count;
            case bytes -> byteCount = count;
        }
    }

    public String generateOutput() {
        var counts = new long[]{lineCount, wordCount, byteCount};
        var output = new ArrayList<String>();
        for (var count: counts) {
            if (count >= 0) {
                output.add(String.valueOf(count));
            }
        }
        output.add(file);
        return String.join("\t", output);
    }
}
