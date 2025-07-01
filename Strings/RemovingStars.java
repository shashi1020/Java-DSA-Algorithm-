public class RemovingStars {

     public static String removeStars(String s) {
       
        StringBuilder sb = new StringBuilder();

       for(int i =0; i<s.length(); i++)
        {
            char nextc = s.charAt(i);
            if(nextc == '*')
            {
                int len = sb.length();
                System.out.println(len);

                if(len > 0 && Character.isLowerCase(sb.charAt(len-1)))
                {
                    sb.deleteCharAt(len-1);
                }
            }else{
                sb.append(s.charAt(i));     
            }
        }
        return sb.toString();
        
    }

 

    public static String removerSpecialchar(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();
        

        while (i < n) {
          char c = s.charAt(i);
          if(c=='*' ||c=='$' || c=='#')
          {

            int count=0;
            while(i<n && s.charAt(i)=='*' ||s.charAt(i)=='$' || s.charAt(i)=='#')
            {
                count++;
                i++;
            } 

            int skippedletters = 0;
            while(skippedletters<count && i < n)
            {
                if(Character.isLowerCase(s.charAt(i)))
                {
                    i++;
                    skippedletters++;
                }else if(s.charAt(i) == ' ' && i+1<n && Character.isLowerCase(s.charAt(i + 1)))
                {
                    sb.append(' ');
                    i+=2; //skip white space and nextlowercase leeter
                    skippedletters++;
                }else{
                    break;
                }
            }
          }else{
            sb.append(c);
            i++;
          }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "thw$ g##bjhdwd vdg*gh$vvdd#bdudhc";
        String output = removerSpecialchar(input);
        System.out.println(output);  // Expected: thw hdwd vdghvdddudhc
    }


}
