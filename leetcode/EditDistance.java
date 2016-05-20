/*

Edit Distance
 
 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
public class EditDistance {
    int dp[][];
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        if(n==0)
            return m;
        if(m==0)
            return n;
        dp = new int[n][m];
        return editD(word1.toCharArray(),word2.toCharArray(),n-1,m-1);
    }
    public int editD(char[] a1, char[] a2, int i, int j){
        if(i==0 && j==0)
            return a1[i]==a2[0]?0:1;
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
        if(dp[i][j]==0){
            if(a1[i]==a2[j]){
                dp[i][j] = editD(a1,a2,i-1,j-1);
            }else{
                dp[i][j] = 1 + Math.min( editD(a1,a2,i-1,j),Math.min(editD(a1,a2,i,j-1),editD(a1,a2,i-1,j-1)) );
            }
        }
        return dp[i][j];
    }
}