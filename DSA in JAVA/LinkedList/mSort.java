public class mSort {

    public static void merge(int[] arr, int left, int mid, int right)
    {
        int s1 = mid - left + 1;
        int s2=  right - mid;
        
        int L[] = new int[s1];
        int R[] = new int[s2];

        for(int i=0; i < s1; i++)
        {
            L[i] = arr[left+i];
        }
        
        for(int j=0; j < s2; j++)
        {
            R[j] = arr[mid + 1 + j];
        }

        int i=0,j=0;
        int k=left;
        while(i < s1 && j < s2)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;

            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < s1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < s2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public static void MergeSort(int arr[], int left, int right)
    { 
        if(left < right){
        int mid = left + (right - left)/2;
        // System.out.println(mid);
           

        MergeSort(arr, left, mid);
        MergeSort(arr, mid+1, right);
            
            // System.out.println(left);
            // System.out.println();
            // System.out.println(right);

        merge(arr, left, mid, right);

        

    }
}
    public static void main(String[] args) {
        int arr[] = {19, 5, 4, 2, 1 };
        int left = 0;
        int right = arr.length-1;

        MergeSort(arr, left, right);
        System.out.println(arr[1]);
    }
}
