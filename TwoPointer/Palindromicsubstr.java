public class Palindromicsubstr{


    public static void main(String[] args) {
        String str = "babada";
        int start = 0, end = 0;

        
        for(int center = 0; center < str.length(); center++)
        {
            int len1 = ExpandAround(str,center,center); // for odd len
            int len2 = ExpandAround(str,center,center+1); // for even len
            int maxlen = Math.max(len1,len2);
            if(maxlen>end-start)
            {
                start = center - (maxlen-1)/2;
                end = center + (maxlen)/2; 
            }
        }
        

        System.out.println(str.substring(start, end+1));
        
    }

    public static int ExpandAround(String s, int left, int right)
    {

        
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
         
        }

        return right-left-1;
    }
}