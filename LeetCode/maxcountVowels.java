import java.util.*;

class maxcountVowels {

    public static int maxVowels(String s, int k)
    {
        int maxCount = 0;
        int count = 0;
        char []vowels = {'a', 'e', 'i', 'o', 'u'};
        for(int i=k; i<k; i++)
        {
            if(isVowel(s.charAt(i), vowels))
            {
                count++;
            }
        }
        maxCount = count;

        for(int i = k; i<s.length();i++)
        {
            if(isVowel(s.charAt(i), vowels))
            {
                count++;
            }
            if(isVowel(s.charAt(i-k), vowels))
            {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;

    }

    public static boolean isVowel(char c, char[] vowels)
    {
        for(char vowel: vowels)
        {
            if(c == vowel)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "leetcode";
        int k=3;     
        System.out.println(maxVowels(str,k));   
    }
}
