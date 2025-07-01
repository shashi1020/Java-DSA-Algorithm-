import java.util.*;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for(int []interval:intervals)
        {
            
            if(interval[1]<newInterval[0])
            {
               
                list.add(interval);  
            }
            else if(interval[0]<=newInterval[1])
            {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
             
            }
            else{
                list.add(newInterval);
                newInterval = interval;
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }   

    public static void main(String[] args) {
        int [][]intervals = {{1,3},{2,6},{8,10},{15,18}};
        int []newI = {3,8};
        int[][] res = insert(intervals,newI); 

        for(int a[]:res)
        {
            System.out.print(a[0]);
            System.out.println(a[1]);
        }
    }
}
