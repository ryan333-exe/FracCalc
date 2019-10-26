package fracCalc;
import java.util.*;
//Ryan Mathew  - last edited 10/11
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String in = input.nextLine();
        while (!in.equalsIgnoreCase("quit")) {
            produceAnswer(in);
            System.out.print("Enter an expression: ");
            in = input.nextLine();
        }
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"

    public static String produceAnswer(String input) {
        // produceAnswer should read the first operand (Ex.: 1/2) and return a float
        input = input.trim();
        String firstOp = input.substring(0, (input.indexOf(" ")));
        String Operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
        String secondOp = input.substring(input.indexOf(" ") + 3, input.length());

        fractionString(firstOp);

        return fractionString(secondOp);


        // TODO: Implement this function to produce the solution to the input
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

    public static String fractionString(String input) {
        int x = 0;
        int y = 0;
        int z = 1;
        int wholePosition;
        int fracSep;
        wholePosition = input.indexOf('_');
        fracSep = input.indexOf('/');
        //if only a whole number exists
        if ((wholePosition == -1) && (fracSep == -1)) {
            x = Integer.parseInt(input);
            y = 0;
            z = 1;
        }
        //if both a whole number and fraction exist
        if ((wholePosition > 0) && (fracSep > 0)) {
            x = Integer.parseInt(input.substring(0, wholePosition));
            y = Integer.parseInt(input.substring(wholePosition + 1, fracSep));
            z = Integer.parseInt(input.substring(fracSep + 1));
        }
        //if only a fraction exists
        if ((wholePosition == -1) && (fracSep > 0)) {
            x = 0;
            y = Integer.parseInt(input.substring(0, fracSep));
            z = Integer.parseInt(input.substring(fracSep + 1));
        }
        return ("whole:" + x + " numerator:" + y + " denominator:" + z);
    }
}

