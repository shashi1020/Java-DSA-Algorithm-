/*Given two strings s and t of lengths m and n respectively, return the minimum window 
substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty st ring "".

The testcases will be generated such that the answer is unique.
Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t. */
import java.util.*;
class MinWinDowSubstring{
    public static String minWinSub(String s, String t)
    {

        String str = "";
        if(s==null || t==null || s.length()<t.length()) return "";

        int n=t.length();
        HashMap<Character, Integer> CharMap = new HashMap<>(); 
        for (char c : t.toCharArray()) {
            CharMap.put(c, CharMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int minlen = Integer.MAX_VALUE;
        int minleft  = 0;
        int count = 0;
        HashMap<Character, Integer> SeenMap = new HashMap<>();

        while(right<s.length())
        {
            char currchar = s.charAt(right);
            if(CharMap.containsKey(currchar))
            {
                SeenMap.put(currchar,SeenMap.getOrDefault(currchar, 0)+1);
                if(SeenMap.get(currchar)<=CharMap.get(currchar))
                {
                    count++;    
                }
            }
            // When all characters from t are found in the current window
            while(count == t.length())
            {
                if(right-left+1<minlen)
                {
                    minlen = right-left+1;
                    minleft = left;
                }
            
                char leftchar = s.charAt(left);
                if(CharMap.containsKey(leftchar))
                {
                    SeenMap.put(leftchar,SeenMap.getOrDefault(leftchar,0)-1);
                    if(SeenMap.get(leftchar)<CharMap.get(leftchar))
                    {
                        count--;
                    }
                }
                left++; 
            }
            right++;
        }

        return minlen ==  Integer.MAX_VALUE ? "" : s.substring(minleft,minleft+minlen);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC"; 
        String t = "ABC";
        System.out.println(minWinSub( s, t));

    }
}