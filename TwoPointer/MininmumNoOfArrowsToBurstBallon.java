import java.util.*;
public class MininmumNoOfArrowsToBurstBallon {

    public static int findMinArrowShots(int[][] points) {
        int arrows = 1;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int currEnd = points[0][1];
        
        for(int []point:points){
            if(currEnd>=point[0])
            {
                continue;
            }
            else{
                arrows++;
            }
            currEnd = point[1];
        }

        return arrows;
    }
    public static void main(String[] args) {
        int points[][] = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(points));
    }
}
