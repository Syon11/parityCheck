package com.parityCheck;

public class Block {
    private boolean block[][] = new boolean[9][9];
    private short blockSize;

    public Block(String message) {
        blockSize = (short)message.length();
        encodeBlock(message);
    }

    public Block(boolean[][] block) {
        this.block = block;
    }

    public void display(){
        System.out.println("");
        for(int i = 0; i < blockSize + 1; i++) {
            System.out.println("");
            for (int j = 0; j < 9; j++) {
                if (block[i][j]) {
                    System.out.print("1 ");
                    continue;
                }
                System.out.print("0 ");
            }
        }
        System.out.println("");
        System.out.println("------------------------");
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int getTotalX(int yPos){
        int total = 0;
        for (int i=0; i < 8; i++){
            if (block[yPos][i]) {
                total++;
            }
        }
        return total;
    }

    public int getTotalY(int xPos){
        int total = 0;
        for (int i = 0; i < 8; i++) {
            if (block[i][xPos]){
                total++;
            }
        }
        return 0;
    }

    public void fixError(int xPos, int yPos){
        this.block[yPos][xPos] = !this.block[yPos][xPos];
    }

    private void encodeBlock(String message) {
        for(int i = 0; i < blockSize; i++){
            block[i] = encodeLetter(message.charAt(i));
        }
        block[blockSize] = encodeVerticals();
    }

    private boolean[] encodeLetter(char letter) {
        boolean[] line = new boolean[9];
        int temp = letter;
        boolean odd = false;
        for (int i = 7; i >=0; i--) {
            if (isOdd(temp)){
                line[i] = true;
                odd = !odd;
                if (temp < 2) {
                    break;
                }
            }
            temp /= 2;
        }
        line[8] = odd;
        return line;
    }

    private boolean isOdd(int currentCalc) {
        return currentCalc % 2 == 1;
    }

    private boolean[] encodeVerticals() {
        boolean[] line = new boolean[9];
        boolean isOdd;
        for (int i = 0; i < 9; i++) {
            isOdd = false;
            for(int j = 0; j < blockSize; j++) {
                if (block[j][i]) {
                    isOdd = !isOdd;
                }
            }
            line[i] = isOdd;
        }
        return line;
    }

    public String decode() {
        String part = "";
        int currentTotal;
        for(int i = 0; i < blockSize; i++) {
            currentTotal = 0;
            for(int j = 7; j >= 0; j--) {
                if (block[i][j]){
                    currentTotal += Math.pow(2, 7-j);
                }
            }
            part = part + (char)currentTotal;
        }
        return part;
    }

}