package org.sai.ccwc.controller;

import org.sai.ccwc.WordCountOption;
import org.sai.ccwc.counters.AbstractCounter;
import org.sai.ccwc.inputprocessor.InputProcessor;
import org.sai.ccwc.outputgenerator.ErrorGenerator;
import org.sai.ccwc.outputgenerator.FileSuccessOutputGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    private final String[] input;
    private final ArrayList<String> output;

    public Controller(String[] input) {
        this.input = input;
        this.output = new ArrayList<>();
    }

    public void start() {
        InputProcessor processor = new InputProcessor(this.input);
        if (processor.isValid()) {
            var wcInput = processor.getInput();
            int index = 0;
            for (String fileName: wcInput.files) {
                try {
                    var options = (WordCountOption[]) wcInput.options.toArray(new WordCountOption[wcInput.options.size()]);
                    Arrays.sort(options);
                    var outputGenerator = new FileSuccessOutputGenerator(fileName);
                    for (WordCountOption option : options) {
                        var counter = AbstractCounter.getInstance(new File(fileName), option);
                        if (counter != null) {
                            var count = counter.getCount();
                            outputGenerator.setCount(option, count);
                        }
                    }
                    this.output.add(outputGenerator.generateOutput());
                } catch (FileNotFoundException e) {
                    this.output.add(ErrorGenerator.generateFileNotFoundError(fileName));
                } catch (IOException e) {
                    this.output.add(ErrorGenerator.generateReadError(fileName));
                }
            }
            for (var line: output) {
                System.out.println(line);
            }
        } else {
            System.out.println(ErrorGenerator.generateCommandError());
        }
    }
}
