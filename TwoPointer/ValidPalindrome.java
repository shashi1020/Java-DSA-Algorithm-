class ValidPalindrome
{

    public static boolean isPalindrome(String s) {
        if(s==null||s.isEmpty())
        {
            return true;
        }
        s = s.replaceAll("[\\s\\p{Punct}]","").toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while(left < right)
        {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            System.out.print(leftChar+" == ");
            System.out.print(rightChar);
            if(leftChar!=rightChar)
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
       System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
