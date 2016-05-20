class TrieNode {
    // Initialize your data structure here.
    public TrieNode elem[];
    public boolean exist;
    public TrieNode() {
        elem = new TrieNode[26];
        exist=false;
    }
}
public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    // Inserts a word into the trie.
    public void insert(String word) {
        if(word==null)
            return;
        if(word.equals(""))
            return;
        int i=0,pos;
        TrieNode temp = root;
        for(i=0;i<word.length();i++){
            pos = word.charAt(i) - 'a';
            if(temp.elem[pos]==null)
                    temp.elem[pos] = new TrieNode();
            temp = temp.elem[pos];
        }
        temp.exist=true;
    }
    // Returns if the word is in the trie.
    public boolean search(String word) {
         if(word==null)
            return true;
        if(word.equals(""))
            return true;
        int i=0,pos;
        TrieNode temp = root;
        for(i=0;i<word.length();i++){
            pos = word.charAt(i) - 'a';
            if(temp.elem[pos]==null){
                return false;
            }
            temp = temp.elem[pos];
        }
        //System.out.println(word+"\t"+(temp.elem==null));
        /*
        boolean is_elem = true;
        for(i=0;i<26;i++){
                is_elem = is_elem && (temp.elem[i]==null);
                //System.out.println((i+'a')+"\t"+(temp.elem[i]==null));
        }
        */
        if(temp.exist)
            return true;
        else
            return false;
    }
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
        if(word==null)
            return true;
        if(word.equals(""))
            return true;
        int i=0,pos;
        TrieNode temp = root;
        for(i=0;i<word.length();i++){
            pos = word.charAt(i) - 'a';
            if(temp.elem[pos]==null){
                return false;
            }
            temp = temp.elem[pos];
        }
        return true;
    }
}
// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
