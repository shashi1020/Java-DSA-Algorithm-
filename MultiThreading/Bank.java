public class Bank {
    private int balance;
    public Bank(int balance)
    {
        this.balance = balance;
    }

    public synchronized void Withdraw(int amount, String ThreadName)
    {   
        if(amount>balance)
        {
            System.out.println(ThreadName+" Insufficient Balance!");
        }else{
            System.out.println(ThreadName+ " Withdrawing amount");
            balance -= amount;
            System.out.println(ThreadName + " Remaining balance = "+ balance);
        }
    }
    
    
}
