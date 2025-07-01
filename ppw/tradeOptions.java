interface tradeOptions
{
  void buyShares(int stockId, String stockName,double PriceperShare,int quantity);
  void sellShares(String stockId,int quantity, double currentPrice);
}
