// Problem 1:
// There is a list of N music shows. Each show has a start time, duration and volume of people attending the show.
// You need to find the maximum total volume of non overlapping intervals.
// Ex.
// startTime = {10,5,15,18,30}
// duration = {30,12,20,35,35}
// volume = {50,51,20,25,10}

// Output: 76

// Here, we can select 2 intervals: 1st starting at 5 with duration 15, 2nd starting at 18 with duration 35
// Total volume of them is 51+25 = 76, which is the maximum possible solution.

// (I had solved this problem completely with 15/15 cases passed)

import java.util.*;
public class NmusicShows {

    public static int findNonOverlappings(List<Show> list, int i){
        int low=0, high=i-1, result=-1;

        while(low<=high)
        {
            int mid = (low+high)/2;
            // System.out.println(mid);
            if(list.get(mid).end <= list.get(i).start)
            {
                result = mid;
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int []startTime = {10,5,15,18,53};
        int []duration = {30,12,20,35,35};
        int []volume = {50,51,20,25,10};

        int n = startTime.length;
        List<Show> list = new ArrayList<>();

        for(int i=0; i<n; i++){
           list.add(new Show(startTime[i],duration[i],volume[i]));
        }

        list.sort(Comparator.comparingInt(s->s.end));

        int dp[] = new int[n];
        dp[0] = list.get(0).volume;

        for(int i=1; i<n; i++)
        {
            int includeVolume = list.get(i).volume;
            System.out.println(includeVolume);

            int lastIndex = findNonOverlappings(list, i);

            if(lastIndex != -1)
            {
                includeVolume+=dp[lastIndex];
            }

            dp[i] = Math.max(dp[i-1],includeVolume);


        }
        System.out.println("max volume of 2 non overlap events is: "+ dp[n-1]);
        

        

    }
}
