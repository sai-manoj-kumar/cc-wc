package org.sai.ccwc.counters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Math.max;

public class ByteCounter extends AbstractCounter {

    public ByteCounter(File file) {
        super(file);
    }

    @Override
    public long getCount() {
        return this.file.length();
    }
}
