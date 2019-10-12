package fracCalc;
import java.util.*;
//Ryan Mathew  - last edited 10/11
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in); 
    	System.out.print("Enter an expression: ");
    	String in = input.nextLine();
        System.out.println(produceAnswer(in));
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
        String firstOp = input.substring(0, (input.indexOf(" ")));
        String Operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
        String secondOp = input.substring(input.indexOf(" ") + 3, input.length());
        // read Operator and check what it is
        // last read the last operand and do the same as the first step.

        //do these steps later
        //Finally execute the actual process to do the math and find the answer
        //for(int i = 0; i < input.length() - 1; i++) {


        // TODO: Implement this function to produce the solution to the input
        
        return secondOp;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    //Plan for produceAnswer method
        //for loop starting from index = 0 thru input.length() - 1
        //use charAt to view individual characters within the string as the index increases
        //Check that character is 0-9, _ (underscore) , / (slash), - (negative sign), or a space(" ").
}
