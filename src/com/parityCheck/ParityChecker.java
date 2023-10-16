package com.parityCheck;

import java.util.ArrayList;

public class ParityChecker {

    private Block block;
    private boolean[] xErrors;
    private boolean[] yErrors;
    private int errorState = 0;


    public ParityChecker(Block block) {
        this.block = block;
        xErrors = new boolean[8];
        yErrors = new boolean[8];
        checkErrors();
        correctErrors();
        verifySolved();

    }

    private void checkErrors() {
        for(int i = 0; i < block.getBlockSize()+1; i++){
            for (int j = 0; j < 8; j++){
                if (block.getTotalY(j) % 2 != 0) {
                    yErrors[j] = !yErrors[j];
                }
            }
            block.getTotalX(i);
            if (block.getTotalX(i) % 2 != 0) {
                xErrors[i] = !xErrors[i];
            }
        }
    }

    private void correctErrors() {
        for (int i = 0; i < block.getBlockSize()+1; i++) {
            for (int j = 0; j < 8; j++) {
                if (yErrors[i] && xErrors[j]) {
                    yErrors[i] = !yErrors[i];
                    xErrors[j] = !xErrors[j];
                    block.fixError(j,i);
                }
            }
        }
    }

    private boolean verifySolved() {
        boolean xSolved = true;
        boolean ySolved = true;

        for (int i = 0; i < block.getBlockSize()+1; i++) {
            if (xErrors[i]) {
                xSolved = false;
            }
        }
        for (int i = 0; i < 8; i++){
            if (yErrors[i]) {
                ySolved = false;
            }
        }
        if (xSolved && ySolved) {
            return true;
        }
        return false;
    }
}
