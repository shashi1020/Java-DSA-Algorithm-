import java.util.*;


class rough
{
        public static List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if(s.length()==0|| s == null || words.length == 0 || words == null)
            {
                return res;
            }
            HashMap<String, Integer> wordmap = new HashMap<>();
            int n = s.length();
            int wordlen = words[0].length();
            int totallen = wordlen*words.length;
            if(n<totallen)
            {
                return res;
            } 
           
            for(String word:words)
            {
                wordmap.put(word, wordmap.getOrDefault(word, 0)+1       );
            }
            for(int i = 0; i<wordlen; i++)
            {
                int left = i;
                int count=0;
                HashMap<String, Integer> seenwords = new HashMap<>();
                for(int right=i; right<=n-wordlen; right +=wordlen)
                {
                    String currentWord = s.substring(right,right+wordlen);
                    if(wordmap.containsKey(currentWord))
                    {
                        seenwords.put(currentWord,seenwords.getOrDefault(currentWord,0)+1);
                        count++;

                        while(seenwords.get(currentWord)>wordmap.get(currentWord))
                        {
                            String leftWord = s.substring(left,left+wordlen);
                            seenwords.put(leftWord, seenwords.getOrDefault(leftWord,0)-1);
                            count--;
                            left += wordlen; 
                        }
                        if(count==words.length)
                        {
                            res.add(left);
                        }
                     }else{
                            seenwords.clear();
                            count = 0;
                            left = right+wordlen;
                        }
                    
                }
            }
            return res;
        }
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> res = new ArrayList<>();
        res = findSubstring(s,words);
        System.out.println(res);
                
    }
}