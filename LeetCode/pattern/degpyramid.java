/*
 
        * 
      * *
    * * *
  * * * *
* * * * *
 

 */
public class degpyramid {
    public static void main(String[] args) {
        int n=5;
       
        for(int i=1; i<=n; i++)
        {
            // inner loop for n-1 spaces
            for(int j=1; j<=n-i;j++)
            {
                System.out.print("  ");
            }
            // inner loop for *
            for(int j=1; j<=i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
           
        }
    }
}
