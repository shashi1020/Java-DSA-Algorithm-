import java.util.*;
class MergeIntervals
{
    public static int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
        {
            return intervals;
        }

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));


        int[] currInt = intervals[0];
        list.add(currInt);
        for(int []interval : intervals)
        {
            int currEnd = currInt[1];
            
            if(interval[0]<=currEnd)
            {
                currInt[1] = Math.max(currEnd,interval[1]);
            }
            else{
                currInt = interval;
                list.add(currInt);
            }

        }

        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {
        int [][]intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals); 

        for(int a[]:res)
        {
            System.out.print(a[0]);
            System.out.println(a[1]);
        }
    }
}