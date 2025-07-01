class Trie {

    static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            if (i == word.length() - 1) {
                curr.endOfWord = true;
            }
            curr = curr.children[idx];
        }
    }

    // search in TRIE - key exists?
    public static boolean Search(String key)
    {
        Node curr = root;
        for(int i=0; i<key.length(); i++)
        {
            int idx = key.charAt(i)-'a';

            if(curr.children[idx]==null)
            {
                return false;
            }

           if(i == key.length()-1 && curr.endOfWord==false)
           {
                return false;
           }
           
           curr = curr.children[idx];
        }
        return true;
    }
    

    public static void main(String[] args) {
        String words[] = {"the","a","there","their", "any","shashi"};

        for(int i=0; i<words.length; i++)
        {
            insert(words[i]);
        }

        System.out.println(Search("the"));
    }

}