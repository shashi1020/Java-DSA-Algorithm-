class Candy{
    
    public static int candy(int[] ratings) {
        if(ratings.length==1)
        {
            return 1; 
        }

        int []candies = new int[ratings.length];

        for(int i=0; i<ratings.length; i++)
        {
            candies[i] = 1;
        }

      
        for(int i = 1; i<ratings.length; i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                candies[i] = candies[i-1]+1;
            }
        }
        for(int i=ratings.length-2; i>=0; i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                if(candies[i]<=candies[i+1])
                {
                    candies[i] = Math.max(candies[i], candies[i+1]+1);
                }
            }
        }
        int candy = 0;
        for(int a:candies)
        {
            System.out.print(a + " ");
            candy += a;
        }
        return candy;
    }
    public static void main(String[] args) {
        candy(new int[]{1,0,2});
    }

}