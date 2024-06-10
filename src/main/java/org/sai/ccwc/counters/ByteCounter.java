package org.sai.ccwc.counters;

import java.io.File;


public class ByteCounter extends AbstractCounter {

    public ByteCounter(File file) {
        super(file);
    }

    @Override
    public long getCount() {
        return this.file.length();
    }
}
