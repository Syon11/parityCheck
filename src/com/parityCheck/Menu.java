package com.parityCheck;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    private boolean active = true;
    private int chosenOption = 0;
    private ArrayList<String> options = new ArrayList<>();

    public Menu(String... options){
        this.options.addAll(Arrays.asList(options));
        do{
            displayMenu();
            chosenOption = askOption();
            executeOption();
        }while(active);
    }

    private void displayMenu(){
        int i = 0;
        for (String option: options)
        {
            i++;
            System.out.println(i + ") " + option);
        }
    }

    private int askOption(){
        System.out.print("Please enter a selection from the above menu: ");
        return Sanitizer.sanitizeIntWithBounds(1, options.size());
    }

    /*THIS FUNCTION REQUIRES EDITION FROM DEV MANAGING THE MENUS*/
    private void executeOption(){

        switch (chosenOption) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
