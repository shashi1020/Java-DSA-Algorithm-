class stockMarketPortfolio{
    private static int stockId;
    private static String stockName;
    private static double PricePerShare;
    final static double TRANSACTION_FEE = 0.02;


    public stockMarketPortfolio(int stockId, String stockName, double PricePerShare, int SharesOwned){
        this.stockId = stockId;
        this.stockName = stockName;
        this.PricePerShare = PricePerShare;  //INR
    }  


   

    
    public int getStockId()
    {
        return stockId;
    }
    public String getStockName(){
        return stockName;
    }
    public double getPricePerShare(){
        return PricePerShare;
    }   

    public static void DisplayMarketStatus(){
        System.out.println("market is Open. Transactions are being Proceeded");
    }
}