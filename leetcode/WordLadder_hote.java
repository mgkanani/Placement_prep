import java.util.*;

public class WordLadder_hote {
    HashSet<String> visited = new HashSet<String>();

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        int val = 0;
        char[] arr = beginWord.toCharArray();

        String bottom = new String();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        q.add(bottom);

        while (!q.isEmpty()) {
            String str = q.remove();
            if (str == bottom) {
                val++;
                if (!q.isEmpty()) q.add(bottom);
            } else {
                if (str.equals(endWord)) return val + 1;
                arr = str.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char temp = arr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String newWord = new String(arr);

                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            q.add(newWord);
                        }
                    }
                    arr[i] = temp;                
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder obj = new WordLadder();
        Set<String> set = new HashSet<String>();
        set.add("a"); set.add("b"); set.add("c");
        System.out.println(obj.ladderLength("a", "c", set));
    }
}
/*
Word Ladder

 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the word list

For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.

*/