import java.util.*;
public class Permuteseq {

    public static void getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=n; i++)
        {
            numbers.add(i);
        }  
        
        int fact[] = new int[n];
        fact[0] = 1;
        for(int i=1; i<n; i++)
        {
            fact[i] = i*fact[i-1];
        }

        k=k-1; // 2 for 3
        StringBuilder sb = new StringBuilder();

        for(int i=n; i>0; i--)
        {
            int index = k/fact[i-1];
            System.out.println(k +"/"+ fact[i-1]); 
            sb.append(numbers.get(index));
            numbers.remove(index);
            k=k%fact[i-1];
            
        }
        System.out.println(sb.toString());
        
    }

    public static void main(String[] args) {
        int n=3;
        int k=3;
        getPermutation(n,k);

    }
}
