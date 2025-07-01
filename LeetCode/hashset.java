
import java.util.HashSet;
import java.util.Iterator;

public class hashset {

    public static void main(String[] args) {
        HashSet<Integer> values = new HashSet<>();

        values.add(1);
        values.add(2);
        System.out.println(values.contains(2));
        
        Iterator it =  values.iterator();

        while(it.hasNext())
        {
     
     
     
     
     
     
     
     
     
     
            System.out.println(it.next());
        }
    }
    
}
