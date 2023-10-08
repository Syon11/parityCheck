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
}
