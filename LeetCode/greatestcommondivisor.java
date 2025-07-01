public class greatestcommondivisor {
    public static String gcdOfStrings(String str1, String str2) {
        int minlength = Math.min(str1.length(), str2.length());
        
        for(int i = 0; i< minlength; i++)
        {
            String substring = str1.substring(0, i+1);
            if(isDivisible(substring, str1) && isDivisible(substring, str2) )
               {
                return substring;
               } 
        }
        return "";
    }

    public static boolean isDivisible(String substring , String str)
    {
        int len = str.length();
        int sublen = substring.length();

        if(len % sublen != 0)
        {
            return false;
        }
        for(int i = 0 ; i<len ; i+=sublen)
        {
            if(!str.substring(i, i+sublen).equals(substring))
            {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String str1 = "ABSABS";
        String str2 = "ABS";

        String result = gcdOfStrings(str1, str2);
        System.out.println(result);
    }
}
