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
            System.out.println(produceAnswer(in));
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
        String retStr = null;
        int [] frac1 = fraction(firstOp);
        int [] frac2 = fraction(secondOp);

        //if the operator is a plus sign
        if (Operator.equals("+")) {
            int den3 = frac1[1] * frac2[1];
            int num3 = (frac1[0] * frac2[1]) + (frac2[0] * frac1[1]);
            int gcd = GCD(num3, den3);
            den3 = den3 / gcd;
            num3 = num3 / gcd;

            retStr = makeMixed(num3, den3);
        }

        //if the operator is a minus sign
        if (Operator.equals("-")) {
            int den3 = frac1[1] * frac2[1];
            int num3 = (frac1[0] * frac2[1]) - (frac2[0] * frac1[1]);
            int gcd = GCD(num3, den3);
            den3 = den3 / gcd;
            num3 = num3 / gcd;

            retStr = makeMixed(num3, den3);
        }

        //if the operator is a times (multiplication) sign
        if (Operator.equals("*")) {
            int num3 = frac1[0] * frac2[0];
            int den3 = frac1[1] * frac2[1];
            int gcd = GCD(num3, den3);
            den3 = den3 / gcd;
            num3 = num3 / gcd;

            retStr = makeMixed(num3, den3);
        }

        //if the operator is a division sign
        if (Operator.equals("/")) {
            int num3 = frac1[0] * frac2[1];
            int den3 = frac1[1] * frac2[0];

            int gcd = GCD(num3, den3);
            den3 = den3 / gcd;
            num3 = num3 / gcd;

            if (den3 < 0) {
                den3 = den3 * -1;
                num3 = num3 * -1;
            }

            retStr = makeMixed(num3, den3);
        }

        return retStr;
        // TODO: Implement this function to produce the solution to the input
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

    public static int[] fraction(String input) {
        int wholeNum = 0;
        int numerator = 0;
        int denominator = 1;
        int wholePosition;
        int fracSep;

        wholePosition = input.indexOf('_');
        fracSep = input.indexOf('/');

        //if only a whole number exists
        if ((wholePosition == -1) && (fracSep == -1)) {
            wholeNum = Integer.parseInt(input);
            numerator = 0;
            denominator = 1;
        }
        //if both a whole number and fraction exist
        if ((wholePosition > 0) && (fracSep > 0)) {
            wholeNum = Integer.parseInt(input.substring(0, wholePosition));
            numerator = Integer.parseInt(input.substring(wholePosition + 1, fracSep));
            denominator = Integer.parseInt(input.substring(fracSep + 1));
        }
        //if only a fraction exists
        if ((wholePosition == -1) && (fracSep > 0)) {
            wholeNum = 0;
            numerator = Integer.parseInt(input.substring(0, fracSep));
            denominator = Integer.parseInt(input.substring(fracSep + 1));
        }

        //performs calculation (multiplying denominator by whole number, then adding it to the numerator making it the new numerator.)
        //finally put the new numerator over the old denominator
        int [] impFrac = new int[2];
        if (wholeNum >= 0) {
            int tempValue = denominator * wholeNum;
            numerator = numerator + tempValue;
            impFrac[0] = numerator;
            impFrac[1] = denominator;
        }
        else {
            int tempValue = denominator * wholeNum;
            numerator = tempValue - numerator;
            impFrac[0] = numerator;
            impFrac[1] = denominator;
        }
        return (impFrac);
    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return GCD(b, a % b);
    }

    public static String makeMixed(int a, int b) {
        String retStr = null;
        if (a == 0) {
            return "0";
        }
        if (a / b != 0) {
            int wholeNum = a / b;
            int tempVal = (Math.abs(a)) % (Math.abs(b));
            if (tempVal == 0) {
                return ("" + wholeNum + "");
            }
            if (wholeNum != 0) {
                retStr = ("" + wholeNum + "_" + tempVal + "/" + b + "");
            } else {
                retStr = ("" + tempVal + "/" + b + "");
            }
        }
        else {
            retStr = ("" + a +"/" + b + "");
        }

        return retStr;
    }
}

