public class MagicNum {
    public static void isMagicNum(int n)
    {
        int sum = 0;
        while(n>0 || sum>9)
        {
            if(n==0)
            {
                n = sum;
                sum = 0;
            }
            sum += n%10;
            n=n/10;
        }
        System.out.println(sum==1);
    }


    public static void main(String[] args) {
            int n=1234;
            isMagicNum(n);

    }
}
