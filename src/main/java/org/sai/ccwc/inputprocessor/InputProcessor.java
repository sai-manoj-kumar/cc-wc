package org.sai.ccwc.inputprocessor;

import org.sai.ccwc.WordCountInput;
import org.sai.ccwc.WordCountOption;

import java.util.*;

public class InputProcessor {

    private final String[] input;

    public InputProcessor(String[] input) {
        this.input = input;
    }

    public boolean isValid() {
        InputValidator validator = new InputValidator(this.input);
        return validator.isValid();
    }

    public WordCountInput getInput() {
        var options = new HashSet<WordCountOption>();
        var start = 0;
        if (this.input[0].startsWith("-")) {
            String optionsString = this.input[0].substring(1);
            Set<Character> optionsSet = new HashSet<>();
            for (char option : optionsString.toCharArray()) {
                optionsSet.add(option);
            }

            for (Character c: optionsSet) {
                if (c == 'l') {
                    options.add(WordCountOption.line);
                } else if (c == 'w') {
                    options.add(WordCountOption.word);
                } else if (c == 'c') {
                    options.add(WordCountOption.bytes);
                }
            }
            start++;
        } else {
            options.addAll(List.of(WordCountOption.values()));
        }

        var wordCountInput = new WordCountInput();
        wordCountInput.files = Arrays.asList(this.input).subList(start, this.input.length);
        wordCountInput.options = options;
        return wordCountInput;
    }
}
