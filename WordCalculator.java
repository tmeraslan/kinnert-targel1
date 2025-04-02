import java.util.Scanner;
public class WordCalculator {
    public static void main(String[] args) {
String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] operators = {"plus", "minus", "times", "dividedby"};
        int cnt1=0,cnt2=1;
        char c_State='p';
        double value=0;
        String expression = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter expression:");
        expression = input.nextLine();
        expression=expression.replace("divided by","dividedby");
        String [] parts = expression.split("\\s+");
        double[] parts_by_numbers=new double[parts.length];
        for (String s : parts)
        {
            for (int x = 0; x < numbers.length; x++)
            {
                if (s.equals(numbers[x]))
                {
                    parts_by_numbers[cnt1] = x;
                    cnt1 += 2;
                }
            }
        }
        for (String part : parts)
        {
            for (int x = 0; x < operators.length; x++)
            {
                if (part.equals(operators[x]))
                {
                    parts_by_numbers[cnt2] = x;
                    cnt2 += 2;

                }
            }
        }
       for(int i=1;i<parts_by_numbers.length;i=i+2)
       {
          if(parts_by_numbers[i]==2)
          {
             parts_by_numbers[i+1]= parts_by_numbers[i-1]*parts_by_numbers[i+1];
             parts_by_numbers[i-1]=0.0;
          }
          if (parts_by_numbers[i]==3)
          {
              parts_by_numbers[i+1]= parts_by_numbers[i-1]/parts_by_numbers[i+1];
              parts_by_numbers[i-1]=0.0;
          }
       }
      value=parts_by_numbers[0];
        for(int i=2;i<parts_by_numbers.length;i=i+2)
      {
         if(parts_by_numbers[i-1]==0)
         {    c_State='p';
         }
         if(parts_by_numbers[i-1]==1)
         {
             c_State='m';
         }
         if(c_State=='p')
         {
             value+=parts_by_numbers[i];
         }
          if(c_State=='m')
          {
              value-=parts_by_numbers[i];
          }
      }
        expression=expression.replace("dividedby","divided by");
      System.out.println( "The value of expression '"+expression+"' is: "+value);
              System.out.println("Enter expression:");

    }
}
