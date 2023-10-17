package com.parityCheck;

import java.util.Scanner;

public class Sanitizer {
    public static int sanitizeInt(){
        return takeIntEntry();
    }

    public static int sanitizeIntWithBounds(int lowerBound, int... upperBound) {
        int sanitizedInput = 0;
        boolean valid = false;

        while (!valid) {
            sanitizedInput = takeIntEntry();
            valid = testOutOfBounds(sanitizedInput, lowerBound, upperBound);
        }
        return sanitizedInput;
    }

    public static String sanitizeString(){
        Scanner scanner = new Scanner(System.in);
        String sanitizedString = "";
        while(true){
            if (scanner.hasNextLine()){
                sanitizedString = scanner.nextLine();
                break;
            }
            System.out.println("Please enter a line");
        }
        return sanitizedString;
    }

    private static int takeIntEntry(){
        Scanner scanner = new Scanner(System.in);
        int entry;
        while (!scanner.hasNextInt()) {
            System.out.println("ERROR: Command entered is not an integer");
            scanner.nextLine();
        }
        entry = scanner.nextInt();
        return entry;
    }

    private static boolean testOutOfBounds(int testedInput, int lowerBound, int... upperBound) {
        if (upperBound.length > 0) {
            if (testedInput >= lowerBound && testedInput <= upperBound[0]) {
                return true;
            }
            System.out.println("ERROR: Entry out of bounds\nPlease enter an integer between " + lowerBound + " and " + upperBound[0]);
            return false;
        }
        if (testedInput >= lowerBound){
            return true;
        }
        System.out.println("ERROR: Entry out of bounds\nPlease enter an integer above " + lowerBound);
        return false;
    }
}
