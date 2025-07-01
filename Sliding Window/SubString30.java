import java.util.*;
public class SubString30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int arrSize = words.length;
        int wordlength = words[0].length();
        int totalLength = arrSize*wordlength;
        
        // System.out.println(s.length()-K);
        for(String word : words)
        {
            map.put(word, map.getOrDefault(word,0)+1);
        }

        for(int i = 0; i<s.length()-totalLength; i++)
        {
            HashMap<String, Integer> seen = new HashMap<>();
            int j=0;
            while(j<words.length)
            {
                int WordIndex = i+j * wordlength;
                
                String CurrentWord = s.substring(WordIndex,WordIndex+wordlength);

                if(!map.containsKey(CurrentWord))
                {
                    break;
                }

                seen.put(CurrentWord,seen.getOrDefault(CurrentWord,0)+1);

                if(seen.get(CurrentWord) > map.get(CurrentWord))
                {
                    break;
                }
                j++;
            }
            if(j==words.length)
            {
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
            String s = "wordgoodgoodgoodbestword";
            String[] words = {"word","good","best","good"};
            List<Integer> res = new ArrayList<>();
            res = findSubstring(s,words);
            System.out.println(res);
                
            // System.out.println(s.substring(4,4+4));
    }
}
