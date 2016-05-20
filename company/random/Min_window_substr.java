import java.util.*;
/*
Finding the Minimum Window in S which Contains All Elements from T
http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
*/
public class Min_window_substr{
	public static void PR(Object obj){ System.out.print(obj); }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		// s1>s2
		int len = process(s1,s2);
		PR(len);
	}
	public static int process(String s1 ,String s2){
		if(s1==null || s2==null)
			return 0;
		if(s1.equals(s2))
			return s1.length();
		int len = s1.length();
		int win = len+5;
		byte arr[] = new byte[26];
		byte arr1[] = new byte[26];
		for(char c: s2.toCharArray()){
			arr[c-'A']++;
		}
		int st=0,end=0;
		int j=0;
		char c='A';
		while(end<len){
			PR("start\t"+st+"\t"+end+"\n");
			//c = s1.charAt(st);
			//first fill arr1
			j=end;
			while(j<len && !comp(arr,arr1)){
				c=s1.charAt(j);
				arr1[c-'A']++;
				j++;
			}
			end = j;
			//delete unwanted characters from starting + delete 1st character matching character.
			j=st;
			while(j<end && comp(arr,arr1)){
				c=s1.charAt(j);
				arr1[c-'A']--;
				j++;
			}
			st=j;
			PR(st-1+"\t"+end+"\n");
			//update window			
			if(win>(end-st+1)){
				win = (end-st+1);
			}
			PR(win+"\n");
		}
		return win>len?-1:win;
	}
	public static boolean comp(byte[] a1, byte[] a2){
		for(int i=0;i<26;i++){
			if(a1[i]>a2[i])
				return false;
		}
		return true;
	}
}