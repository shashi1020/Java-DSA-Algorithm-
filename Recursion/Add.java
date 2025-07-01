public class Add {

    public int add(int n, int sum)
    {
        if(n == 0)
        {
            return sum;
        }
        sum += add(n-1, sum+1);
        

        return sum;
    }
    
    public static void main(String[] args) 
    {
        Add obj = new Add();
        int Sum = obj.add(5, 0);
        System.out.println(Sum);        
    }
}
