class ButterflyPattern{
    public static void main(String[] args) {
        

        int n=4;
        for(int i=1; i<=9; i++)
        {
            for(int j=1; j<=10; j++)
            {
                if(i>=j && i<=5 || i<=5 && j>=11-i)
                {
                    System.out.print("  *");
                }
                else if(i<j && i>5 || i>5 && j<=10-i)
                {
                    System.out.print("  *");
                }
                else{
                    System.out.print("   ");

                }
                               
            }
            System.out.println();
        }
    }
}