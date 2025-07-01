import java.util.InputMismatchException;
import java.util.Scanner;
public class division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num1 = null;
        
        try{
            System.out.println("Enter the Numerator = ");
            num1 = sc.nextInt();

            System.out.println("Enter the Denominator = ");
            int num2 = sc.nextInt();
            int res  = num1/num2;
            System.out.println("result = "+res);
            num1 = null;
            System.out.println(num1.toString());
        }
        catch(ArithmeticException e){e.printStackTrace();}
        catch(NullPointerException e){e.printStackTrace();}
        catch(InputMismatchException e){e.printStackTrace();}
        finally{
            sc.close();
            System.out.println("Program Terminated");
        }

    }
}
