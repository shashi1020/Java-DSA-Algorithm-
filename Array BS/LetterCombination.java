import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

   public static List<String> letterCombinations(String digits) {
    if(digits==null || digits.length()==0)
    {
        return new ArrayList<>();
    }
        
   Map<Character, String> map = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );

     List<String> res = backTrack(digits, map, "", new ArrayList<>());
    return res;
    }

    public static List<String> backTrack(String nextDigit,Map<Character, String>map,String combination, List<String> res)
    {

        if(nextDigit.isEmpty()){
            res.add(combination);
            return res;
        }
        char digit = nextDigit.charAt(0);
        String letters = map.get(digit);

        for(int i=0; i<letters.length(); i++)
        {
            res = backTrack(nextDigit.substring(1),map, combination+letters.charAt(i), res);
        }

        return res;
    }

    public static void main(String[] args) {
            String digits = "23";
            System.out.println(letterCombinations(digits));
    }
}
