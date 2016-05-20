import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Given N strings. Each string contains only lowercase letters from a−j(both inclusive). The set of N strings is said to be GOOD SET if no string is prefix of another string else, it is BAD SET.

For example, aab, abcde, aabcd is BAD SET because aab is prefix of aabcd.

Print GOOD SET if it satisfies the problem requirement.
Else, print BAD SET and the first string for which the condition fails.

Input Format
First line contains N, the number of strings in the set.
Then next N lines follow, where ith line contains ith string.

Constraints
1≤N≤105
1≤ Length of the string ≤60

Output Format
Output GOOD SET if the set is valid.
Else, output BAD SET followed by the first string for which the condition fails.

Sample Input00

7
aab
defgab
abcde
aabcde
cedaaa
bbbbbbbbbb
jabjjjad

Sample Output00

BAD SET
aabcde

Sample Input01

4
aab
aac
aacghgh
aabghgh

Sample Output01

BAD SET
aacghgh

Explanation
aab is prefix of aabcde. So set is BAD SET and it fails at string aabcde.
*/
class Trie{
    Trie elem[];
    boolean end;
    Trie(){
        elem = new Trie[26];
        end=false;
    }
    public boolean insert(String word){
        Trie t1=this;
        if(t1.end)//one such prefix have been inserted earlier.
            return false;
        if(word==null || word.equals("")){//end of the string.
            //t1.end=true;
            return false;
        }
        char c = word.charAt(0);
        if(t1.elem[c-'a']==null){//another string found.
            t1.elem[c-'a'] = new Trie();
            if(word.length()==1){
                t1.elem[c-'a'].end=true;
                return true;
            }
        }
        return t1.elem[c-'a'].insert(word.substring(1));
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i=0;
        Trie trie= new Trie();
        String str = null;
        boolean flag=true;
        StringBuilder br = new StringBuilder(1000);
        while(i<t){
            str = sc.next();
            if(flag){
                flag = flag && trie.insert(str);
                if(!flag)
                    br.append("BAD SET\n"+str+"\n");
            }
            i++;
        }
        if(flag)
            br.append("GOOD SET\n");
        System.out.println(br);
    }
}
