import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HexaGrid {
    static String s1,s2;
    static boolean dp[][], visited[][];
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        int itr=0;
        int n,c1,c2,i1;
        while(itr<T){
            //System.out.println(sc.nextInt());
            n = sc.nextInt();
            s1 = sc.next();
            s2 = sc.next();
            dp = new boolean[n+1][n+1];
            visited = new boolean[n+1][n+1];
            if(check(n,n))
                System.out.println("YES");
            else
                System.out.println("NO");
            itr++;
        }
    }
    public static boolean check(int i, int j){
        if(i<=2 || j<=2){
            if(i==2 && j==2 && s1.charAt(0)=='0' && s1.charAt(1)=='1' && s2.charAt(0)=='1' && s2.charAt(1)=='0'){
                dp[i][j] = false;
            }else if(i>2){
                if(s1.charAt(i-1)=='1'){
                    dp[i][j] = check(i-1,j);
                }
                else if(s1.charAt(i-2)=='1')
                    dp[i][j] = false;
                else
                    dp[i][j] = check(i-2,j);
            }else if(j>2){
                if(s2.charAt(j-1)=='1'){
                    dp[i][j] = check(i,j-1);
                }
                else if(s2.charAt(j-2)=='1')
                    dp[i][j] = false;
                else
                    dp[i][j] = check(i,j-2);
            }else{
                int c1=0,c2=0,i1=0,i2=0;
                while(i1<i){if(s1.charAt(i1)=='1') c1++; i1++;}
                while(i2<i){if(s2.charAt(i2)=='1') c2++; i2++;}
                if((Math.abs(i+j-c1-c2)&1)==0)
                    dp[i][j] = true;
                else
                    dp[i][j] = false;
            }
        }else if(!visited[i][j]){
            visited[i][j]=true;
            if(s1.charAt(i-1)=='1')
                dp[i][j] = dp[i][j] || check(i-1,j);
            if(s2.charAt(i-1)=='1')
                dp[i][j] = dp[i][j] || check(i,j-1);
            if(s1.charAt(i-1)=='0' && s1.charAt(i-2)=='0'){
                dp[i][j] = dp[i][j] || check(i-2,j);
            }
            if(s2.charAt(j-1)=='0' && s2.charAt(j-2)=='0'){
                dp[i][j] = dp[i][j] || check(i,j-2);
            }
            if(s1.charAt(i-1)=='0' && s2.charAt(j-1)=='0'){
                dp[i][j] = dp[i][j] || check(i-1,j-1);
            }
        }
        return dp[i][j];
    }
}