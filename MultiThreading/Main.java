
public class Main{
    public static void main(String[] args) {
        Bank account = new Bank(100000);
        Thread t1 = new Thread(()->account.Withdraw(1000, "t1"));

        Thread t2 = new Thread(){
            public void run(){
                account.Withdraw(1000,"t2");
            }
        };
        t1.start();
        t2.start();
    }
}