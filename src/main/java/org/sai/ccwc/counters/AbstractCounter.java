package org.sai.ccwc.counters;
import org.sai.ccwc.WordCountOption;

import java.io.*;

public abstract class AbstractCounter {
    protected File file;

    public AbstractCounter(File file) {
        this.file = file;
    }

    public abstract long getCount() throws FileNotFoundException, IOException;

    public static AbstractCounter getInstance(File file, WordCountOption option) {
        switch (option) {
            case line -> {
                return new LineCounter(file);
            }
            case word -> {
                return new WordCounter(file);
            }
            case bytes -> {
                return new ByteCounter(file);
            }
            default -> {
                return null;
            }
        }
    }
}
