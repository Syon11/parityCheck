package com.parityCheck;

import java.util.ArrayList;
import java.util.Collections;

public class Encoder {

    final private String message;
    final private ArrayList<Block> blocks = new ArrayList<>();
    private Parser parser;

    public Encoder() {
        System.out.println("Please enter the message to encode");
        message = Sanitizer.sanitizeString();
    }
    public void run() {
        parser = new Parser(message);
        encode();
        displayEncodedMessage();
    }
    public void displayEncodedMessage() {
        System.out.println("Full encoded message:");
        for (Block block: blocks) {
            block.display();
        }
    }
    public ArrayList<Block> getBlocks(){
        return blocks;
    }
    private void encode() {
        ArrayList<String> splitMessage = parser.splitMessage();
        for (String msg: splitMessage) {
            blocks.add(new Block(msg));
        }
        Collections.reverse(blocks);
    }
}
