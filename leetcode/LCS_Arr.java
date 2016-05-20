import java.util.*;

/*

The Longest Common Subsequence


Problem Statement

A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, which is common to both the sequences.

Given two sequence of integers, A=[a1,a2,…,an] and B=[b1,b2,…,bm], find any one longest common subsequence.

In case multiple solutions exist, print any of them. It is guaranteed that at least one non-empty common subsequence will exist. 


Input Format

First line contains two space separated integers, n and m, where n is the size of sequence A, while m is size of sequence B. In next line there are n space separated integers representing sequence A, and in third line there are m space separated integers representing sequence B.

n m
A1 A2 … An 
B1 B2 … Bm  

Constraints

1≤n≤100
1≤m≤100
0≤ai<1000,where i∈[1,n]
0≤bj<1000,where j∈[1,m]

Output Format

Print the longest common subsequence and each element should be separated by at least one white-space. In case of multiple answers, print any one of them.

Sample Input

5 6
1 2 3 4 1
3 4 1 2 1 3

Sample Output

1 2 3

Explanation

There is no common subsequence with length larger than 3. And "1 2 3", "1 2 1", "3 4 1" are all correct answers. 
*/
public class LCS_Arr{
	static int dp[][];
	//static String s1,s2;
	//static StringBuilder br;
    static int[] arr1,arr2;
    static int[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        arr1 = new int [n];
        arr2 = new int[m];
        for(int i=0;i<n;i++)
            arr1[i]=sc.nextInt();
        for(int i=0;i<m;i++)
            arr2[i]=sc.nextInt();
//		s1 = sc.next();
//		s2 = sc.next();
		dp = new int[n][m];
		int len = lcs(n,m);
		//System.out.println(len);
		res = new int[len];
		getSeq(len,n-1,m-1);
        for(int i: res)
		  System.out.print(i+" ");
	}

	public static int lcs(int m, int n){
		if(m<=0 || n<=0){
			return 0;
		}
		if(dp[m-1][n-1]!=0){
			return dp[m-1][n-1];
		}
		int ret=0;
		if(arr1[m-1]==arr2[n-1])
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
        res[len-1] = arr1[i1];
		//br.append(s1.charAt(i1));
		return ;
	}
}