import java.util.*;
public class LongestCommonSubString{
	static String st1,st2;
	static int dp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		max(a);
		String s1 = sc.next();
		String s2 = sc.next();
		st1=s1;
		st2=s2;
		int m=s1.length(),n=s2.length();
		dp = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				dp[i][j]=-1;
		}
		lcss(dp,m-1,n-1);
		int max=0,x=0,y=0;
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(max<dp[i][j]){
					max = dp[i][j];
					x=i;
					y=j;
				}
				//System.out.print(dp[i][j]+" ");
			}
			//System.out.println();
		}
		System.out.println(s1.substring(x-dp[x][y]+1,x+1));
	}
	static int lcss(int[][] dp, int i, int j){
		if(i<0||j<0)
			return 0;
		if(dp[i][j]==-1){
			if(st1.charAt(i)==st2.charAt(j))
				dp[i][j] = 1 + lcss(dp,i-1,j-1);
			else{
				dp[i][j]=0;
				lcss(dp,i-1,j);
				lcss(dp,i,j-1);
			}
		}
		return dp[i][j];
	}


	static int max(int a[]){
		int window=0,max=a[0],jumps=0;
		int i=0;
		for(i=0;i<=window && window < a.length-1;i++){
			max = Math.max(max,i+a[i]);
			if(i==window){
				window =max;
				jumps++;
			}
		}
		System.out.println(jumps);
		return jumps;
	}
}