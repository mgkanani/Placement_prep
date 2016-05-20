import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    public boolean isIsomorphic(String s, String t) {
	ArrayList<Integer> str_t[] = ( ArrayList<Integer> []) new ArrayList[128];
	ArrayList<Integer> str_s[] = ( ArrayList<Integer> []) new ArrayList[128];
/*
        int str_s[]= new int[26];
        int str_t[]= new int[26];
*/
	if(s==t)
		return true;
	else if(s==null || t==null)
		return false;
        int i=0, len = s.length();
        char c;
        for(i=0;i<len;i++){
            c = s.charAt(i);
            //str_s[c-'a']++;
	str_s[c].add(i);
        }
        for(i=0;i<len;i++){
            c = t.charAt(i);
	    str_t[c].add(i);
            //str_t[c-'a']++;
        }
	int a1[] =new int[128];
	int a2[] =new int[128];
        for(i=127;i>=0;i--){
		a1[i]=str_s[i].size();
	}
        for(i=127;i>=0;i--){
		a2[i]=str_t[i].size();
	}
        Arrays.sort(a1);
        Arrays.sort(a2);
        for(i=25;i>=0;i--){
            if(a1[i]!=a2[i])
                return false;
            if(a1[i]==0 || a2[i]==0)
                return true;
        }
        return true;
    }
public static void main(String arg[]){
	Solution s= new Solution();
	System.out.println(s.isIsomorphic("aab","aba"));
}
}
