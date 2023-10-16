package com.parityCheck;

import java.util.ArrayList;

public class Parser {
    private String unformattedString;

    public Parser(String message) {
        this.unformattedString = message;
    }

    public ArrayList<String> splitMessage(){
        ArrayList<String> messages = new ArrayList<>();
        int loops = calcLoops();
        if(unformattedString.length() > 8){
            for (int i = loops-1; i >= 0; i--){
                messages.add(unformattedString.substring(i*8));
                unformattedString = unformattedString.substring(0,i*8);
            }
            return messages;
        }
        messages.add(unformattedString);
        return messages;
    }

    private int calcLoops() {
        return ((unformattedString.length()/8) + 1);
    }
}
