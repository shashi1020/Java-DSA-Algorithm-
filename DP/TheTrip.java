import java.util.*;

public class TheTrip {
    public static List<Double> equilizeExpense(ArrayList<ArrayList<Double>> list)
    {
        List<Double> res = new ArrayList<>();

        for(ArrayList<Double> listi : list)
        {
            int size1 = listi.size();
            Double avg = calculateAverage(listi);
            Double moneytobeexchanged = 0.00;

            for(int i=0; i<size1; i++)
            {
                if(avg < listi.get(i))
                {
                    moneytobeexchanged +=  listi.get(i) - avg;
                }
            }
            res.add(moneytobeexchanged);

        }

        
        

        return res;
    }

    public static Double calculateAverage(ArrayList<Double> list)
    {
        Double avg = 0.00;
    
        for(Double a : list)
        {
            avg += a;
        }
        return avg/list.size();
    }
    


    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Double>> allTrip = new ArrayList<>();

        while(true)
        {
            int n = sc.nextInt();
            if(n==0) break;

            ArrayList<Double> eachTrip = new ArrayList<>();

            for(int i=0; i<n; i++)
            {
                eachTrip.add(sc.nextDouble());
            }
            allTrip.add(eachTrip);
        }
        System.out.println(equilizeExpense(allTrip));

    }       
}
