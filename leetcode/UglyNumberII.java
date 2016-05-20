/*
Ugly Number II

 Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
*/
public class UglyNumberII {
    int dp[];
    int n;
    public int nthUglyNumber(int n) {
        this.n = n;
        dp = new int[n];
        dp[0]=1;
        generate(1);
//        for(int i =0; i<n ;i++)
//            System.out.println(dp[i]);
        return dp[n-1];
    }
    
    public void generate(int i){
        if(i==n)
            return;
        else{
            int min1=dp[i-1],min2=dp[i-1],min3=dp[i-1];
            int j;
            j=0;
            while(dp[j]*5<=min1){
                j++;
            }
            min1 = dp[j]*5;
            j=0;
            while(dp[j]*3<=min2){
                j++;
            }
            min2 = dp[j]*3;
            j=0;
            while(dp[j]*2<=min3){
                j++;
            }
            min3 = dp[j]*2;
            min1 = Math.min(min1,min2);
            dp[i] = Math.min(min1,min3);
            generate(i+1);
        }
    }
}