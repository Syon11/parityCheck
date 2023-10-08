package com.parityCheck;

import java.util.Scanner;

public class Sanitizer {
    public static int sanitizeInt(){
        Scanner scanner = new Scanner(System.in);
        int sanitizedInput = 0;

        while(!scanner.hasNextInt()){
            System.out.println("ERROR: Command entered is not an integer");
            scanner.nextLine();
            System.out.println("Please enter an integer");
        }
        sanitizedInput = scanner.nextInt();


        return sanitizedInput;
    }

    public static int sanitizeIntWithBounds(int lowerBound, int... upperBound) {
        Scanner scanner = new Scanner(System.in);
        int sanitizedInput = 0;
        boolean valid = false;

        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("ERROR: Command entered is not an integer");
                scanner.nextLine();
                if (upperBound.length > 0) {
                    System.out.println("Please enter an integer between " + lowerBound + " and " + upperBound[0]);
                    continue;
                }
                System.out.println("Please enter an integer equal or above to " + lowerBound);
            }
            sanitizedInput = scanner.nextInt();
            System.out.println(sanitizedInput);
            if (upperBound.length > 0) {
                if (sanitizedInput >= lowerBound && sanitizedInput <= upperBound[0]) {
                    break;
                }
                System.out.println("ERROR: Entry out of bounds");
                System.out.println("Please enter an integer between " + lowerBound + " and " + upperBound[0]);
                scanner.nextLine();
                continue;
            }
            if (sanitizedInput >= lowerBound){
                break;
            }
            System.out.println("ERROR: Entry out of bounds");
            System.out.println("Please enter an integer above " + lowerBound);
            scanner.nextLine();
        }
        return sanitizedInput;
    }


    public static String sanitizeString(){
        Scanner scanner = new Scanner(System.in);
        String sanitizedString = "";
        while(!scanner.hasNextLine()){
            sanitizedString = scanner.nextLine();
            if (sanitizedString.isEmpty()){
                System.out.println("Please enter a line");
                continue;
            }
            break;
        }
        return sanitizedString;
    }

}
