public class rough {
    public static int reverseInt(int x){
        int maxint = Integer.MAX_VALUE;
        int minint = Integer.MIN_VALUE;

        if(x>maxint || x<minint)
        {
            return 0;
        }
        int result = 0;
        while(x!=0)
        {
            result = result * 10 + (x%10);
            x = x/10;
            
        }
        if(result>maxint || result<minint)
        {
            return 0;
        }
        return result;
    }
    public static void main(String[] args) {

        int x = -121;
        int temp = x;
        
        int reverse = 0;
        while(x!=0)
        {   
            int digit = x%10;   
            reverse = reverse *10 + digit;
            x /=10;
        }
        System.out.println(temp == reverse);

    }
}
