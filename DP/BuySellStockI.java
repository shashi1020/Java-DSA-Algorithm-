public class BuySellStockI {
    public static void maxProfit(int[] prices) {
    //    second approach
    //  well find the minprice in the array and according to that array well calculate maxprice

    int maxProfit = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;

    for(int i=0; i<prices.length; i++)
    {
        if(prices[i] < minPrice)
        {
            minPrice = prices[i];
        }else if(prices[i]-minPrice >maxProfit){
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
        }
    }


    System.out.println(maxProfit);
        
        
    }

    

    public static void main(String[] args) {
        int []prices = {7,1,5,3,6,4};
        maxProfit(prices);

        // int maxProfit1 = Integer.MIN_VALUE;
        // int profit = 0;
        // int []profitnloss = new int[prices.length-1];
        
        // for(int i=0; i<prices.length-1; i++)
        // {
        //     profitnloss[i] = prices[i+1]-prices[i];
        // }


        // for(int price:profitnloss)
        // {
        //     profit = profit+price;
        //     maxProfit1 = Math.max(profit,maxProfit1);

        //     if(profit<0)
        //     {
        //         profit=0;
        //     }
        // }
        // int val = -1;
        // int in = Integer.MIN_VALUE;

        // if(val<in)
        // {
        //     System.out.println(true);
        // }
        // else{
        // System.out.println(false);
        // }
    }
}
