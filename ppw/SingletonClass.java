import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SingletonClass implements tradeOptions {

    private Map<String , Integer> OwnedStocks;
    private Map<String, Double> PurchasePrice;
    private static SingletonClass instance = null;
    
    private SingletonClass(){
        OwnedStocks = new HashMap<>();
        PurchasePrice = new HashMap<>();


    }

    public static synchronized SingletonClass getInstance(){
        if(instance == null)
        {
            instance = new SingletonClass();
        }
        return instance;
    }

    @Override
    public void buyShares(int stockId, String stockName, double PricePerShare , int quantity)
    {
        OwnedStocks.put(stockName, OwnedStocks.getOrDefault(stockName, 0)+quantity);
        PurchasePrice.put(stockName,PricePerShare);
        System.out.println(quantity + " bought of "+stockName+ " for " + quantity*PricePerShare);
    }

    @Override
    public void sellShares(String stockName, int quantity, double CurrentPrice){
        if(!OwnedStocks.containsKey(stockName) || OwnedStocks.get(stockName)<quantity)
        {
            System.out.println("Insufficient shares to sell");
            return;
        }
        double boughtPrice = PurchasePrice.get(stockName);
        double CP = boughtPrice * quantity;
        double SP = quantity * CurrentPrice;
        double POL = SP - CP  - (stockMarketPortfolio.TRANSACTION_FEE * quantity);
         
         OwnedStocks.put(stockName, OwnedStocks.get(stockName)-quantity);
         if(OwnedStocks.get(stockName)==0)
         {
            OwnedStocks.remove(stockName);
            PurchasePrice.remove(stockName);
         }

         if(POL<0)
         {
            System.out.println(stockName+" sold for "+SP+" at the LOSS of "+ POL);
         }else{
         System.out.println(quantity+" "+stockName+" sold for "+SP+" at the profit of "+ POL);

         }

    }

    
}
