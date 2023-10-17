package com.parityCheck;

import java.util.ArrayList;

public class Program {
    private Encoder encode;
    private ParityChecker validate;
    private Decoder decode;
    String message = "";
    private ArrayList<Block> blocks;
    private boolean unsolvableError;

    public Program() {
        blocks = new ArrayList<>();
    }


    public void run() {
        encode = new Encoder();
        encode.run();
        blocks = encode.getBlocks();
        for (Block block: blocks) {
            validate = new ParityChecker(block);
            if (validate.run()){
                System.out.println("ERROR: Block too corrupted to be solvable. Please retry program");
                unsolvableError=true;
                break;
            }
        }
        if (unsolvableError) {
           return;
        }
        decode = new Decoder(blocks);
        message = decode.run();
        decode.printMessage();
    }
}
