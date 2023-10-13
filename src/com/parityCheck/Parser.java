package com.parityCheck;

import java.util.ArrayList;

public class Parser {
    private String unformattedString;

    public Parser(String message) {
        this.unformattedString = message;
    }

    public ArrayList<String> splitMessage(){
        ArrayList<String> messages = new ArrayList<>();

        if(unformattedString.length() > 8){
            for (int i = calcLoops(); i > 0; i--){
                messages.add(unformattedString.substring(i*8));
                
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
