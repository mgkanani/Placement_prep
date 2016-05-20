import java.util.*;
/*
LCS with String 

The Longest Common Subsequence


*/
public class LCS{
	static int dp[][];
	static String s1,s2;
	static StringBuilder br;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s1 = sc.next();
		s2 = sc.next();
		dp = new int[s1.length()][s2.length()];
		int len = lcs(s1.length(),s2.length());
		System.out.println(len);
		br = new StringBuilder(len);
		getSeq(len,s1.length()-1,s2.length()-1);
		System.out.println(br);
	}

	public static int lcs(int m, int n){
		if(m<=0 || n<=0){
			return 0;
		}
		if(dp[m-1][n-1]!=0){
			return dp[m-1][n-1];
		}
		int ret=0;
		if(s1.charAt(m-1)==s2.charAt(n-1))
			ret = 1 + lcs(m-1,n-1);
		else
			ret = Math.max(lcs(m-1,n),lcs(m,n-1));
		dp[m-1][n-1] = ret;
		return ret;
	}

	public static void getSeq(int len, int i, int j){
		if(len==0)
			return;
		int i1=i,j1=j;
		while(i1>=0 && dp[i][j]==dp[i1][j1]){
			i1--;
		}
		i1++;
		while(j1>=0 && dp[i][j]==dp[i1][j1]){
			j1--;
		}
		j1++;
		getSeq(len-1,i1-1,j1-1);
		br.append(s1.charAt(i1));
		return ;
	}
}