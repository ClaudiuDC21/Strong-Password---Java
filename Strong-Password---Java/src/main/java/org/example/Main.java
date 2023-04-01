package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * This function makes the minimum number of changes for the password to make is strong.
     * @param s String to be checked.
     * @return minim number of changes for a strong password.
     */
    public static int minimNumberOfChanges(String s) {
        boolean hasDigit = false, hasUpperCase = false, hasLowerCase = false;
        for (int index = 0; index < s.length(); index++) { // we go through the entire String S
            char c = s.charAt(index);
            if (Character.isDigit(c)) // check if we have at least 1 digit in String s
                hasDigit = true;
            else if (Character.isLowerCase(c)) // check if we have at least 1 lower case in String s
                hasLowerCase = true;
            else if (Character.isUpperCase(c)) // check if we have at least 1 upper case in String s
                hasUpperCase = true;
        }

        // it is checked if we have at least one digit, one lower case and one upper case
        int caseChanging = 0, minimumChanges = 0;
        if (!hasDigit) // if there is no digit, the caseChanging variable is incremented
            caseChanging++;
        if (!hasLowerCase) // if there is no lower case, the caseChanging variable is incremented
            caseChanging++;
        if (!hasUpperCase) // if there is no upper case, the caseChanging variable is incremented
            caseChanging++;

        // the length check starts, and depending on this, the minimum number of changes increases
        if (s.length() < 6) { // initially it is checked if the length of the password is less than 6
            int difference = 6 - s.length(); // difference is used to see how many more characters are needed for the password to reach 6
            if (s.length() <= 3) // if the length of the password is less than 3,
                minimumChanges += difference; // the minimum number is the distance up to 6
            else minimumChanges += Math.max(caseChanging, difference); // if not, the minimum number of changes is
            // chosen from the largest value between the distance and the appearance of a number, upper or lower case
        } else if (s.length() > 20) // if the length is greater than 20, the minimum number of changes is determined by
            minimumChanges += s.length() - 20 + caseChanging; // the difference up to 20, plus the replacement of some
            // characters to be at least 1 of the 3 types
        else minimumChanges += caseChanging;
         // if the number of letters is met, the minimum number of changes is added with caseChanging

        // it is checked if there are 3 identical characters, one next to the other
        for (int index = 1; index < s.length() - 1; index++) { // we go through the String from 1 to the penultimate value
            if (s.charAt(index) == s.charAt(index - 1) && s.charAt(index) == s.charAt(index + 1)) {
                minimumChanges++;
                //  if there is, we go 3 positions to the right, and it is checked
                index += 2;
            }
        }
        // the minimum number of changes is returned (0 if the password is already strong)
        return minimumChanges;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the -Strong password checker-");
        System.out.println("Please insert your password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        System.out.println("You entered " + "'" + password + "' !" );
        int changes = minimNumberOfChanges(password);
        if(changes > 0)
            System.out.println(changes + " is the minimum number of changes for this password to be strong!");
        else  System.out.println("Congratulations, your password is strong!");

    }
}