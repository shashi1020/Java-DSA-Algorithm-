public class MainClass {
    public static void main(String[] args) {
        stockMarketPortfolio.DisplayMarketStatus();
        SingletonClass instance = SingletonClass.getInstance();
        if(instance!=null)
        {
            System.out.println("you can buy or sell Shares");
        }

        instance.buyShares(1, "Birla Opus Paints", 9, 100);
        instance.sellShares("Birla Opus Paints", 50, 18);
    }
}
