/*

* * * * * *
 *       *
   *   *
     * 
   
   
 */
public class p {
        public static void main(String[] args) {
            int n=6;
            int m=4;
            for(int i=0; i <= m ; i++)
            {
                for(int j=0; j < i; j++)
                {
                    System.out.print("  ");
                }

                for(int j = i; j <= n-i ; j++ )
                {
                    if (i == 0 || j == i || j == n - i) {
                    System.out.print("* ");
                    }
                    else{
                        System.out.print("  ");
                    }
                }
                System.out.println();
                

            }
            
        }    

}
