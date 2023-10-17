package com.parityCheck;

import java.util.ArrayList;

public class Decoder {
    private ArrayList<Block> blocks;
    private String message = "";
    public Decoder(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public String run() {
        for (Block block: blocks) {
            message = message.concat(block.decode());
        }
        return message;
    }

    public void printMessage() {
        System.out.println("The message is: " + message);
    }


}
