public class mergealternate
{
    public String arrangealt(String word1, String word2)
    {
       char result[] = new char[word1.length() + word2.length()];
       int i=0, j=0, k=0; 
       while(i<word1.length() && j<word2.length())
       {
        result[k++] = word1.charAt(i++);
        result[k++] = word2.charAt(j++);
       }

       while(i < word1.length()){
        result[k++] = word1.charAt(i++);
        
       }
       while(j < word2.length())
       {
        result[k++] = word2.charAt(j++);
       }

       return new String(result);
       
    }
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

       

        mergealternate obj = new mergealternate();

        System.out.println(obj.arrangealt(word1, word2));

        word1 = "ab";
        word2 = "pqrs";
        System.out.println(obj.arrangealt(word1, word2)); // Output: "apbqrs"

        word1 = "abcd";
        word2 = "pq";
        System.out.println(obj.arrangealt(word1, word2)); // Output: "apbqcd"
    }
}