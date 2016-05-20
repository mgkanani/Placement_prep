import java.util.*;
public class LongestSubSeq{
	static int [][]dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		dp = new int[s1.length()][s2.length()];
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++)
				dp[i][j]=-1;
		}
		lcs(s1,s2,0,0);
/*		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
*/		System.out.println(dp[0][0]);
		System.out.println(generate(s1,s2,dp));
	}
	static int lcs(String s1,String s2, int i, int j){
		if(i>=s1.length() || j>=s2.length())
			return 0;
		if(dp[i][j]==-1){
			if(s1.charAt(i)==s2.charAt(j))
				dp[i][j] = 1 + lcs(s1,s2,i+1,j+1);
			else
				dp[i][j] = Math.max(lcs(s1,s2,i,j+1),lcs(s1,s2,i+1,j));
		}
		return dp[i][j];
	}

	static String generate(String s1, String s2, int[][] dp){
		int m =dp.length;
		int n = dp[0].length;
		int i1=0,j1=0;
		int cnt = dp[0][0];
		StringBuilder br = new StringBuilder(cnt);
		while(true){
			while(j1<n && i1<m-1 && dp[i1][j1]==dp[i1+1][j1]) i1++;
			while(j1<n-1 && i1<m && dp[i1][j1]==dp[i1][j1+1]) j1++;
			if(i1<m && j1<n){
				br.append(s1.charAt(i1));
				i1++;
				j1++;
			}else
				break;
		}
		return br.toString();
	}
}