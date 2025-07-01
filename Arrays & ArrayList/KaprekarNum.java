public class KaprekarNum {
    public static void returnKaprekarNum(int L, int R)
    {

        int rem2=0;
        for(int i=L;i<=R; i++){
     
            int currentNum = i;
            int currNum =i*i;

            int rem1 = currNum%10;
            currNum /=10; 
            if(currNum/10!=0)
            {
                rem2 = currNum%10;  
                currNum /=10;
            }
            int secNum = rem2*10+rem1;
            

            if(currNum+secNum == currentNum)
            {
                System.out.println(currentNum + "->" +true);
            }         
            else{
                System.out.println(currentNum + "->" +false);
            }
        }
        
    }
    public static void main(String[] args) {
        int L=10;
        int R=10;
        returnKaprekarNum(L,R);
    }
}
