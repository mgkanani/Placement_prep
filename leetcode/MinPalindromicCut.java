public class MinPalindromicCut {
    public int minCut(String s) {
        if(s==null)
            return 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        int i,j;
        int len = s.length();
        for (i=len-1;i>=0;i--){
            for (j=i;j<len;j++){
                if ((s.charAt(i)==s.charAt(j)) && (j-i<2 || dp[i+1][j-1])){
                    dp[i][j]=true;
                }else{
                    dp[i][j]=false;
                }
            }
        }
        int val[] = new int[len];
        for(i=1;i<len;i++){
            if(dp[0][i])
                val[i]=0;
            else{
                val[i] = val[i-1]+1;
                for(j=1;j<i;j++){
                    if(dp[j][i]){
                        val[i] = Math.min(val[i],val[j-1]+1);
                    }
                }
            }
        }
        return val[len-1];
    }
}
/*
Palindrome Partitioning II

 Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
*/