package com.parityCheck;

import java.util.ArrayList;

public class ParityFromString extends Parity {
    private String message = "batman";
    private ArrayList<String> splitMessage = new ArrayList<>();
    private Parser parser;
    public ParityFromString() {
        System.out.println("Please enter the message to encode");
        message = Sanitizer.sanitizeString();

    }

    public void run() {
        parser = new Parser(message);
        splitMessage = parser.splitMessage();

    }
}
