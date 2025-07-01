import java.util.ArrayList;
class kidscandy {
    public static ArrayList<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int ith;
        ArrayList<Boolean> res = new ArrayList<>();
        for(int i = 0; i< candies.length; i++)
        {
            ith = candies[i] + extraCandies;
            
            if(isTrue(candies , ith, i))
            {
                res.add(true);
            }
            else{
            res.add(false);
            }
        }
        return res;
    }

    public static Boolean isTrue(int []candies, int ith, int index)
    {
        for(int i=0; i< candies.length; i++)
        {
            if(i != index && ith < candies[i])
            {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int []candies = {0,3,5,1,3};
        int extraCandies = 3;
       
        ArrayList<Boolean> res = new ArrayList<>();
        res = kidsWithCandies(candies, extraCandies);

        for(Boolean i : res)
        {
            System.out.println(i);
        }
         
    }
}