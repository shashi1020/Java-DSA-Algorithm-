import java.util.*;
public class Lmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new LinkedHashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("enter");
        for(int i =0 ; i<5; i++)
        {
            String name = sc.next();
            int roll = sc.nextInt();
            map.put(name, roll);
        }
        System.out.println(map);
    }
}
