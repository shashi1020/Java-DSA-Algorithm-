class GCD{
    public static int GreatestCommonDivisor(int a, int b){
        int result = Math.min(a,b);
        while(result>0)
        {
            if(a%result == 0 && b%result==0)
            {
                break;
            }
            result--;
        }
        return result;

    }



      public static int LCM(int a, int b){

        int greatest = Math.max(a,b);
        int smallest = Math.min(a,b);

        for(int i=greatest; ; i+=greatest)
        {
            
            System.out.println(i);
            if(i % smallest==0)
            {
                return i;
            }
        }
    }
  

    public static void main(String[] args) {
            System.out.println(LCM(12, 18));
    }
}