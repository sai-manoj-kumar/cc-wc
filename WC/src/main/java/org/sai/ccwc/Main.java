package org.sai.ccwc;

import org.sai.ccwc.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(args);
        controller.start();
    }
}