public class Csortarr {
    public static int Focc(int key, int[] arr, int i)
    {
        if(i== arr.length)
        {
            return -1;
        }
        if(arr[i] == key)
        {
            return i;
        }
        return Focc(key, arr, i+1);
    }
      public static void main(String[] args) {
        int arr[] = {92, 47, 82, 94, 52};
        int key = 94;
        int k = Focc(key, arr,1);
        if(key != 0)
        {
            System.out.println("key found at index "+k);
        }
        else{
            System.out.println("key is not present in array");

        }
      }
    
}
