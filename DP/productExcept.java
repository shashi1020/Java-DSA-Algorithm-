public class productExcept {
    public static void main(String[] args) {
        int arr[] = {10,3,5,6,2};

        int n =arr.length;


        int result[] = new int[n];
        result[0] = 1;
        for(int i=1; i<n; i++)
        {   
            result[i] = result[i-1]*arr[i-1];
               
        }
        int suffix = 1;
        for(int i=n-1; i>=0; i--)
        {
            result[i] *= suffix;
            suffix *= arr[i];
        }

        for(int a: result)
        {
            System.out.println(a);
        }

    }
}
