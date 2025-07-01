public class napsack {

    public static void Sort(float profit[], float weight[], float capacity)
    {
        float fract[] = new float[profit.length];
        for(int i=0; i < profit.length; i++)
        {
            fract[i] = profit[i] / weight[i];
        }
        for(int i=1; i<fract.length; i++)
        {
            for(int j=0; j < fract.length; j++)
            {
                if(fract[i] > fract[j])
                {
 
                    float temp = fract[i];
                    fract[i] = fract[j];
                    fract[j] = temp;

                    float temp1 = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp1;

                    float temp2 = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp2;
                }
            }
        }    
        // soutarr(fract);
        napsac(profit, weight, capacity);

    }

    public static void napsac(float profit[], float weight[], float capacity)
    {
        float remainingcap = capacity;
        float selectedprofit = 0;
        for(int i=0; i < weight.length; i++)
        {
        if(remainingcap > weight[i] && remainingcap != 0)
        {
            selectedprofit = selectedprofit +  profit[i];
            remainingcap = remainingcap - weight[i];
        }
        else if(remainingcap < weight[i] && remainingcap != 0)
        {
            selectedprofit = selectedprofit  + profit[i] *   remainingcap /weight[i];
            remainingcap = 0;
            
        }
        if(remainingcap <= 0)
        {
            break;
        }
    }
        
    System.out.println(selectedprofit);
    }
    public static void soutarr(float arr[])
    {
        for(float x : arr)
        {
            System.out.println( x+ " ");
        }

    }
    public static void main(String[] args)
    {
        float profit[] = {60, 100, 120};
        float weight[] = {10, 20, 30};
        float sackcap = 50;
        Sort(profit, weight, sackcap);
    }
}
