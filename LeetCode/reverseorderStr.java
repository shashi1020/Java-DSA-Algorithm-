class reverseorderStr {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        String[] str = s.trim().split("\\s+");
        int end = str.length-1;

        for(int i=end; i>=0; i--)
        {
            sb.append(str[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
        
    }

    public static void main(String[] args)
    {
      String str = "the sky is blue";
      System.out.println(reverseWords(str));

    

    }
}