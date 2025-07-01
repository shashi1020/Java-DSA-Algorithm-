import java.util.HashMap;
import java.util.Set;

public class Leet383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> wordmap = new HashMap<>();
        for(int i=0; i<ransomNote.length(); i++)
        {
            char c = ransomNote.charAt(i);
            wordmap.put(c,wordmap.getOrDefault(c,0)+1);
        }
        // Set<Character> keys = wordmap.keySet();

        // // Example: Iterating over the keys
        // for (Character key : keys) {
        //     System.out.println("Key: " + key + ", Value: " + wordmap.get(key));
        // }
        for(int i=0; i<magazine.length(); i++)
        {
            char c = magazine.charAt(i);
            if(wordmap.containsKey(c))
            {
               int newCount = wordmap.get(c)-1;
               if(newCount==0)
               {
                wordmap.remove(c);
               }else{
                wordmap.put(c,newCount);
               }     
            }
            if(wordmap.isEmpty())
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote,magazine));

    }
}
