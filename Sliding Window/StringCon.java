// Substring with Concatenation of All Words
/*You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

 

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9] */

import java.util.List;
import java.util.ArrayList;

class StringCon{

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> idx = new ArrayList<>();
        




        return idx;   
    }
    public static void main(String[] args) {
    String s = "boofarthefarboo";
    String words[] = {"boo","far"};
    
    findSubstring(s,words);
    
    }
}