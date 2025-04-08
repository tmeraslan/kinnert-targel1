import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class WordCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression:");
        String input = scanner.nextLine();
        System.out.print("The value of expression ");
        String str1 =input.trim().replaceAll("\\s+", " ");
        ArrayList<String> words = new ArrayList<>(Arrays.asList(str1.split(" ")));
        for (String name : words) {

            switch (name) {

                case "zero":
                    System.out.println("zero ");
                    break;
                case "one":
                    System.out.print("one ");
                    break;
                case "two":

                    System.out.print("two ");

                    break;
                case "three":

                    System.out.print("three ");

                    break;
                case "four":

                    System.out.print("four ");

                    break;
                case "five":

                    System.out.print("five ");

                    break;
                case "six":

                    System.out.print("six ");

                    break;
                case "seven":
                    System.out.print("seven ");
                    break;
                case "eight":
                    System.out.print("eight ");
                    break;
                case "nine":
                    System.out.print("nine ");
                    break;
                case "ten":
                    System.out.print("ten ");
                    break;
                case "plus":
                    System.out.print("plus ");
                    break;
                case "minus":
                    System.out.print("minus ");
                    break;
                case "times":
                    System.out.print("times ");
                    break;
                case "divided":
                    System.out.print("divided by ");
                    break;

            }


        }


        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            if (word.equals("times") || word.equals("divided")) {
                int left = wordToNumber(words.get(i - 1));
                int right = wordToNumber(words.get(i + 1));
                int result;
                if(word.equals("times")){

                    result=left*right ;
                }else{

                    result=left/right;
                }
                words.set(i - 1, "" + result);
                words.remove(i + 1);
                words.remove(i);
                i = 0;
            }
        }


        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            if (word.equals("plus") || word.equals("minus")) {

                int left = wordToNumber(words.get(i - 1));
                int right = wordToNumber(words.get(i + 1));
                int result ;
                if(word.equals("plus")){
                    result=left + right ;

                }else{
                    result=left - right ;
                }
                words.set(i - 1, "" + result);
                words.remove(i + 1);
                words.remove(i);
                i = 0;
            }
        }

        System.out.println("is" +" " +wordToNumber(words.get(0)));
    }


    public static int wordToNumber(String word) {
        switch (word) {

            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
                return 10;
        }


        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') {
                result = result * 10 + (c - '0');
            }
        }
        return result;
    }
}
