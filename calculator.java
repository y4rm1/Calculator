package Calculator;
import java.util.*;

//compile: javac calculator.java
// run: java calculator.java

public class calculator{
    //main method
    public static void main( String args[] ){
        System.out.println("Enter your input in the following format:");
        System.out.println("<number> <operator> <number> ...");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] tokens = input.split(" "); //split by whitespace

        //processing
        try {
            List<Double> numbers = new ArrayList<>();
            List<Character> operators = new ArrayList<>();
            
            for (int i = 0; i < tokens.length; i++) {
                if (i % 2 == 0) {//number
                    numbers.add(parseNumber(tokens[i])); 
                } else { //operator
                    operators.add(tokens[i].charAt(0)); 
                }
            }
        
            double result = numbers.get(0);
            for (int i = 0; i < operators.size(); i++) { //allows for multiple inputs
                char operator = operators.get(i);
                double num2 = numbers.get(i + 1);
                result = calculate(result, num2, operator);
            }

            System.out.println("OUTPUT: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid format. Please make sure you enter valid numbers.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scan.close();
        }
    }
        
    //makes it so user can input either integer or decimal 
    public static double parseNumber(String token) {
        if (token.contains(".")) {
            return Double.parseDouble(token);
        } else {
            return Integer.parseInt(token);
        }
    }

    //basic functions of operations
    public static double add (double num1, double num2){ 
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

    //handles calculations
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