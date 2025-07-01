    import java.util.ArrayList;
    import java.util.List;

    public class TextJustification {

        public static String justify(List<String> grp, int maxWidth, boolean isLastLine)
        {
            StringBuilder sb = new StringBuilder();
            int totallen = 0;

            for(String word : grp)
            {
                totallen += word.length();
            }
            int totalSpaces = maxWidth - totallen;

            if(grp.size()==1||isLastLine==true)
            {
                sb.append(String.join(" ",grp));
                while(sb.length()<maxWidth)
                {
                    sb.append(" ");
                }
            }
            else{
                int grpsize = grp.size()-1;
                int extraspaces = totalSpaces % grpsize;
                int equalspaces = totalSpaces / grpsize;

                for(int i=0; i<grp.size(); i++)
                {
                    sb.append(grp.get(i));
                    if(i<grpsize)
                    {
                        int spacesToAdd = equalspaces + (i<extraspaces?1:0);
                        for(int j=0; j<spacesToAdd; j++)
                        {
                            sb.append(" ");
                        }
                    }

                }
            }

            System.out.println(sb.toString());
            return sb.toString();
        }
        
        public static List<String> fullJustify(String[] words, int maxWidth) {

            List<String> result = new ArrayList<>();
            List<String> currgrp = new ArrayList<>();
        
            int currLen=0;

            for(String word:words){

                if(currLen + word.length() + currgrp.size() > maxWidth)
                {
                    result.add(justify(currgrp, maxWidth,false));
                    currgrp.clear();
                    currLen=0;
                    
                }
                currgrp.add(word);
                currLen += word.length();
                
            }

            if(!currgrp.isEmpty())
            {
                result.add(justify(currgrp, maxWidth,true));
            }

            return result;
        }
        public static void main(String[] args) {
            String []words = {"This", "is", "an", "example", "of", "text", "justification."}; 
            
            int maxWidth = 16;
            List<String> res = fullJustify(words,maxWidth);
            System.out.println(res);
        }
    }
