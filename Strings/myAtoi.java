public class myAtoi {
        public static int myAtoii(String s) {
            if(s == null || s.length()==0)
            {
                return 0;
            }
            int result = 0;
            int sign = 1;
            int i=0;
            int n = s.length();

            while(i<n && Character.isWhitespace(s.charAt(i)))
            {
                i++;
            }

            if(s.charAt(i) =='-')
            {
                sign = -1;
                i++;
            }
            while(i<n &&  Character.isDigit(s.charAt(i))  )
            {
                int digit = s.charAt(i)-'0';

                if(result>(Integer.MAX_VALUE - digit) / 10 ){

                    return (sign==1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = result*10+digit;
                i++;
            }
            return result*sign;
        }
    public static void main(String[] args) {
        String s = " -43";
        System.out.println(myAtoii(s));

    }
}
