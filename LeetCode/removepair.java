import java.util.Arrays;
public class removepair {
    public static int sumpair(int arr[], int k)
    {
       
        Arrays.sort(arr);
        int count=0;
        int loopSize=arr.length;
        
        for(int i=0; i<loopSize; i++)
        {
            boolean Flag = false;
                for(int j=i+1; j<loopSize; j++)
                {
                    if(arr[i]+arr[j] == k)
                    {
                        arr = removeindex(arr, i, j);
                        loopSize=arr.length;
                        Flag=true; 
                        break;
                    }
                }
             if(Flag)
         {
             i=-1;
             count++;
         }
        }
        
        return count;
    }
    

    public static int[] removeindex(int []arr, int a, int b)
    {
        int[] newarr = new int[arr.length-2];
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(i != a && i != b)
            {
                newarr[j++] = arr[i];
            }
        }
      
        return newarr;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int k=5;
        
        System.out.println((sumpair(arr,k)));
    }
}
