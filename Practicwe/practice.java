import java.util.Scanner;

class practice{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number : ");
        int Num = sc.nextInt();
        

        while(Num != 1)
        {
            if(Num%2 == 0)
            {
                Num = Num / 2;
                System.out.println(Num);
            }
            else{
                Num = (Num * Num) + 1;
                System.out.println(Num);
            }
        } 

    }
}