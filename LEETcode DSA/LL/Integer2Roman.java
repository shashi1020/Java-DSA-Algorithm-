import java.util.HashMap;
import java.util.Map;

public class Integer2Roman {
    public static String Convert(int num){
        StringBuilder sb = new StringBuilder();
        int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String roman[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I",};

        Map<Integer,String> map = new HashMap<>();

            for(int i=0; i<values.length; i++)
                while(num>=values[i])
                {
                    System.out.println(num+">"+values[i]+" "+roman[i]);
                    System.out.println();
                    num = num - values[i];
                    sb.append(roman[i]);

                }

            return sb.toString(); 
    }
    public static void main(String[] args) {
        System.out.println(Convert(3749));
    }
}
