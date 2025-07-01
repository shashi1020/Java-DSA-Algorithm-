public class Longestpalisubstring {

    public static String longestPalindrome(String s) {
        int start = 0, end=0;
        

        for(int center=0; center<s.length(); center++)
        {
           int len1 = ExpandAround(s, center, center);
           int len2 = ExpandAround(s, center, center+1);
           int maxLen = Math.max(len1, len2);

           if(maxLen> end-start)
           {
             start = center - (maxLen-1)/2;
             end = center+(maxLen/2);
           }


        }

        return s.substring(start, end+1);


    }
    public static int ExpandAround(String s, int i, int j){

            while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }
            return j-i-1;
    }

    public static void main(String []args){
            String s = "babad";
            
            System.out.println(longestPalindrome(s));
    }
}
