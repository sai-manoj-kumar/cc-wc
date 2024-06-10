package org.sai.ccwc.counters;

import java.io.*;

public class LineCounter extends AbstractCounter {

    public LineCounter(File reader) {
        super(reader);
    }

    @Override
    public long getCount() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            long lineCount = 0;
            String lastLine = null;
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                lineCount++;
                lastLine = line;
            }
            if (lastLine != null && !lastLine.isEmpty() && lastLine.isBlank()) {
                lineCount -= 1;
            }
            return lineCount;
        }
    }
}
