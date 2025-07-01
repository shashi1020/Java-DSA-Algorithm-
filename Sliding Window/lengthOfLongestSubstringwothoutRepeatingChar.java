import java.util.*;
class lengthOfLongestSubstringwothoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
       
       int start = 0;
       int k =0;
        Map<Character, Integer> map = new HashMap<>();
        for(int end = 0; end < s.length(); end++)
        {
            char c = s.charAt(end);
            if(map.containsKey(c))
            {
                if(start<=map.get(c))
                {
                    
                    start = map.get(c)+1;
                }
            }
            k = Math.max(k,end-start+1);
            map.put(c,end);
        }
        Set<Character> keys = map.keySet();
        for (char key:keys) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
        return k;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}