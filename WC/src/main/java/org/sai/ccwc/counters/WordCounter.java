package org.sai.ccwc.counters;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter extends AbstractCounter {

    public WordCounter(File file) {
        super(file);
    }

    @Override
    public long getCount() throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            long wordCount = 0;
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.isBlank()) {
                    List<String> filteredList = Arrays.stream(line.split(" "))
                            .filter(s -> !s.isEmpty())
                            .toList();

                    wordCount += (filteredList.size());
                }
            }
            return wordCount;
        }
    }
}
