package Calculator;
import java.util.*;

//compile: javac calculator.java
// run: java calculator.java

public class calculator{
    //main method
    public static void main( String args[] ){
        System.out.println("Enter your input in the following format:");
        System.out.println("<decimal> <operator> <decimal>");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] tokens = input.split(" "); //split by whitespace
        
        if (tokens.length != 3) {
            System.out.println("Invalid input format. Please use: <number> <operator> <number>");
            scan.close();
            return;
        }

        //processing
        try {
            double num1 = Double.parseDouble(tokens[0]);
            char operator = tokens[1].charAt(0);
            double num2 = Double.parseDouble(tokens[2]);
            System.out.println("OUTPUT: " + calculate(num1, num2, operator));
        } catch (NumberFormatException e) {
            System.out.println("Invalid format. Please make sure you enter valid numbers.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scan.close();
        }
    }
        


    //basic functions
    public static double add (double num1, double num2){ 
    // for more than two inputs,
    // put put the earlier result as num1 and the next input as num2, 
    //and so on
        return num1 + num2;
    }
    public static double subtract (double num1, double num2){ 
        return num1 - num2;
    }
    public static double multiply (double num1, double num2){ 
        return num1 * num2;
    }
    public static double divide (double num1, double num2){ 
        if (num2 == 0){
            return Double.NaN; 
        }
        return num1 / num2;
    }

    public static double calculate(double num1, double num2, char operator){
        double result = 0;
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operator!");
                return Double.NaN;
        }
        return result;
    }
}