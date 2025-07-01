class MedianOf2SortedArrays{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i = 0;
        int j= 0;
        int k = 0;
        int []merged = new int[m+n];

        while(i<m && j<n)
        {
            if(nums1[i]<nums2[j])
            {
                merged[k++] = nums1[i++];
            }else{
                merged[k++] = nums2[j++];
            }
        }

       
        while(i<m)
        {
            merged[k++] = nums1[i++];
        }
        while(j<n)
        {
            merged[k++] = nums2[j++];
        }
        
        // for(int a : merged)
        // {
        //     System.out.print(a);
        // }

        if(merged.length % 2 != 0)
        {
            return merged[merged.length/2];
        }
        return ((merged[merged.length/2] + merged[merged.length/2-1])/2.0);
    }

    public static void main(String[] args) {
        int []nums1 = {1,3}; 
        int []nums2 = {2,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}