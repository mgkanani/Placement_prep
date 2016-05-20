import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestPalindromSubSeq {
    static int dp[][];
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int v1=0,v2=0,max=0,n=s.length();
        
        dp = new int[n][n];
        int i1,j1,i2,j2;
        char arr[] = s.toCharArray();
        for(int i=1;i<s.length();i++){
            i1 = 0;
            j1 = i;
            v1 = lps(arr,i1,j1);
            i2 = i+1;
            j2=n-1;
            v2 = lps(arr,i2,j2);
            if(v1*v2>max)
                max = v1*v2;
        }
        //print(n);
        System.out.println(max);
    }
    public static int lps(char[] arr, int i, int j){
        if(i>arr.length || j<0 || i>j)
            return 0;
        else if(i>=j-1){
            if(arr[i]==arr[j] && i!=j)
                return 2;
            else
                return 1;
        }else if(dp[i][j]==0){
            if(arr[i]==arr[j]){
                dp[i][j] = 2 + lps(arr,i+1,j-1);
            }else{
                dp[i][j] = Math.max(lps(arr,i+1,j),lps(arr,i,j-1));
            }
        }
        return dp[i][j];
    }
    
    public static void print(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}



/*
Longest Palindromic SubSequence
Longest Palindrom SubSequence


Play with words


Problem Statement

Shaka and his brother have created a boring game which is played like this:

They take a word composed of lowercase English letters and try to get the maximum possible score by building exactly 2 palindromic subsequences. The score obtained is the product of the length of these 2 subsequences.

Let's say A and B are two subsequences from the initial string. If Ai & Aj are the smallest and the largest positions (from the initial word) respectively in A ; and Bi & Bj are the smallest and the largest positions (from the initial word) respectively in B, then the following statements hold true:
Ai≤Aj,
Bi≤Bj, &
Aj<Bi.
i.e., the positions of the subsequences should not cross over each other.

Hence the score obtained is the product of lengths of subsequences A & B. Such subsequences can be numerous for a larger initial word, and hence it becomes harder to find out the maximum possible score. Can you help Shaka and his brother find this out?

Input Format
Input contains a word S composed of lowercase English letters in a single line.

Output Format
Output the maximum score the boys can get from S.

Constraints
1<|S|≤3000
each character will be a lower case english alphabet.

Sample Input:

eeegeeksforskeeggeeks

Sample Output:

50

Explanation

A possible optimal solution is eee-g-ee-ksfor-skeeggeeks being eeeee the one subsequence and skeeggeeks the other one. We can also select eegee in place of eeeee, as both have the same length.
*/