import java.util.*;
class map{
    public static void main(String[] args) {
        HashMap<String,Integer> mapT = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<5; i++)
        {
            String a = sc.next();
            mapT.put(a,mapT.getOrDefault(a,0)+1);
        }

        for(Map.Entry<String,Integer> entry: mapT.entrySet())
        {
                String key = entry.getKey();
                int value = entry.getValue();
                System.out.println(key + " : "+ value);
        }
    }
}