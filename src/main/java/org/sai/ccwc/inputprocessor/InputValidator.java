package org.sai.ccwc.inputprocessor;

import org.sai.ccwc.WordCountOption;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    private final String[] input;

    InputValidator(String[] input) {
        this.input = input;
    }

    boolean isValid() {
        if (this.input.length < 1) {
            return false;
        }

        if (this.input[0].startsWith("-")) {
            if (this.input.length == 1) {
                return false;
            }

            String optionsString = this.input[0].substring(1);
            if (optionsString.length() > 3) {
                return false;
            }
            for (char c: optionsString.toCharArray()) {
                if (c == 'c' || c == 'l' || c == 'w') {
                    continue;
                }
                return false;
            }
        }

        return true;
    }

}
