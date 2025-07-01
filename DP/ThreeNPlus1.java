public class ThreeNPlus1 {

    public static int basicFunction(int n)
    {
        int count=1;
        while(n!=1)
        {
            if(n%2!=0)
            {
                n=3*n+1;
                count++;
            }else{
                n /= 2;
                count++;
            }
        }  
        return count;
    }
    public static int maxCycliclen(int i, int j){
        int maxLen=0;

        for(int n=i; n<=j; n++)
        {
            maxLen = Math.max(basicFunction(n),maxLen);
        }

        return maxLen;
    }
    
    public static void main(String[] args) {

        System.out.println(maxCycliclen(900,1000));

    }
}
