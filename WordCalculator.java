/*
    Kamal Tarif 212009492
    Adham Safadi 021549134
 */

package HomeWork_1;
import java.util.Scanner;

public class WordCalculator {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);

        System.out.println("Enter expression:");
        String str = input.nextLine().toLowerCase().trim();
        String[] words = str.split(" ");

        if (words.length < 3 || words.length % 2 == 0) {
            System.out.println("Incomplete or invalid expression.");
            return;
        }

        int total = 0;
        int currentValue = wordToNumber(words[0]);
        if(currentValue == -1) {
            System.out.println("Invalid number: " + words[0]);
            return;
        }

        String Op = "plus";

        for(int i=1;i<words.length;i+=2) {
            String operator = words[i];
            int nextNumber = wordToNumber(words[i+1]);

            if(operator.equals("times")) {
                currentValue = currentValue * nextNumber;
            } else if(operator.equals("divided")) {
                if (nextNumber == 0) {
                    System.out.println("Cannot divide by zero.");
                    return;
                }
                currentValue = currentValue / nextNumber;
            } else if (operator.equals("plus") || operator.equals("minus")) {
                if (Op.equals("plus")) {
                    total += currentValue;
                } else if (Op.equals("minus")) {
                    total -= currentValue;
                }
                Op = operator;
                currentValue = nextNumber;
            } else {
                System.out.println("Invalid operator: " + operator);
                return;
            }
        }

        // ביצוע פעולה אחרונה (חיבור או חיסור)

        if (Op.equals("plus")) {
            total += currentValue;
        } else if (Op.equals("minus")) {
            total -= currentValue;
        }

        System.out.println("The value of expression '" + str + "' is: " + total);

    }

    // פונקציה שמחזירה את הערך של המספרים מהמחרוזת
    public static int wordToNumber(String word) {
        switch (word) {
            case "zero": return 0;
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            case "ten": return 10;
            default: return -1;
        }
    }

}

//output:
/*
	Enter expression:
    eight divided two plus seven plus two times three minus one
    The value of expression 'eight divided two plus seven plus two times three minus one' is: 16
 */
