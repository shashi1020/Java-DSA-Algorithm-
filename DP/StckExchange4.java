    public class StckExchange4 {
        // Brute force approach 
            // - i will calculate ffrom day 1
            // till k 
            // i will store it it maxProfit 
            // then start from day 2 
            // and so on 

        public static int maxProfit(int k, int[] prices) {
            
            return maxProfitrec(prices,0,k, false);
        }

        public static int maxProfitrec(int[] prices, int day, int transactionsLeft, boolean holding)
        {
            if(day>=prices.length || transactionsLeft == 0)
            {
                return 0;
            }
            
            if(holding)
            {
                // sell today
                int sell = prices[day] + maxProfitrec( prices, day+1,transactionsLeft-1,false);
                // skip today
                int skip = maxProfitrec(prices,day+1,transactionsLeft,true);
                return Math.max(sell,skip);
            }else{
                // buy today
                int buy = -prices[day] + maxProfitrec(prices,day+1,transactionsLeft,true);

                // skip today
                int skip = maxProfitrec(prices, day+1,transactionsLeft,false);
                return Math.max(buy,skip);

            }
        }

        public static void main(String[] args) {
            int []prices =  {3,2,6,5,0,3};
            int k=2;
            System.out.println(maxProfit(k,prices));
        }
    }
