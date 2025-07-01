class printnum{
    public static void printnumbers(int n)
    {
        if( n==1)
        {
            System.out.println(n);
            return;
        }
        System.out.println(n + " ");
        printnumbers(n-1);
    }

    public static void printinc(int n)
    {
            if(n == 1)
            {
                System.out.println(n);
                return;
            }
            printinc(n-1);
            System.out.println(n);
    }

    public static int prinfact(int n)
    {
        if( n == 1 || n == 0)
        {
            return 1;
        }
        
        int fact = n * prinfact(n-1);
       
        return fact;
    }

    public static void main(String[] args) {
        int n = 5;

        int fact = prinfact(n);
        System.out.println(fact);
    }
}