import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinTable {
    static int n,m;
    static int r[]= {0,0,-1,1};
    static int col[]= {-1,1,0,0};
    static char c[]= {'L','R','U','D'};
    static int memo[][][];
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int K;
        String s[] = sc.nextLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        K=Integer.parseInt(s[2]);
        char[][] arr= new char[n][m];
        memo = new int[K+1][n][m];
        for(int i=0;i<K+1;i++)
            for(int j=0;j<n;j++)
                for(int l=0;l<m;l++)
                    memo[i][j][l]=-1;
        for(int i=0;i<n;i++)
            arr[i] = sc.nextLine().trim().toCharArray();
        //System.out.println(K);
            int res = dp(K,0,0,arr);
        System.out.println((res>=Integer.MAX_VALUE/2)?-1:res);
    }
    
    public static int dp(int k, int i, int j, char[][] arr){
        //System.out.println(i+"\t"+j+"\t"+arr[i][j]);
        if(k<0 || i>=n || j >=m || i<0 || j<0)
            return Integer.MAX_VALUE/2;
        if(arr[i][j]=='*'){
            //tab[k][]
            //System.out.println("Yes");
            return 0;
        }
        else if(memo[k][i][j]==-1) {
            int val = Integer.MAX_VALUE,v1;
            for(int l=0;l<r.length;l++){
                v1 = dp(k-1,i+r[l],j+col[l],arr);                
                if(arr[i][j]!=c[l]){
                    v1 = v1+1;
                }
                val = Math.min(val,v1);
            }
            memo[k][i][j] = val;
        }
        return memo[k][i][j];
    }
}

/*

Coin on the Table



Problem Statement

You have a rectangular board consisting of N rows, numbered from 1 to N, and M columns, numbered from 1 to M. The top left is (1,1) and the bottom right is (N,M). Initially - at time 0 - there is a coin on the top-left cell of your board. Each cell of your board contains one of these letters:

    *: Exactly one of your cells has letter '*'.

    U: If at time t the coin is on cell (i,j) and cell (i,j) has letter 'U', the coin will be on cell (i−1,j) at time t+1, if i>1. Otherwise, there is no coin on your board at time t+1.

    L: If at time t the coin is on cell (i,j) and cell (i,j) has letter 'L', the coin will be on cell (i,j−1) at time t+1, if j>1. Otherwise, there is no coin on your board at time t+1.

    D: If at time t the coin is on cell (i,j) and cell (i,j) has letter 'D', the coin will be on cell (i+1,j) at time t+1, if i<N. Otherwise, there is no coin on your board at time t+1.

    R: If at time t the coin is on cell (i,j) and cell (i,j) has letter 'R', the coin will be on cell (i,j+1) at time t+1, if j<M. Otherwise, there is no coin on your board at time t+1.

When the coin reaches a cell that has letter '*', it will stay there permanently. When you punch on your board, your timer starts and the coin moves between cells. Before starting the game, you can make operations to change the board, such that you are sure that at or before time K the coin will reach the cell having letter '*'. In each operation you can select a cell with some letter other than '*' and change the letter to 'U', 'L', 'R' or 'D'. You need to carry out as few operations as possible in order to achieve your goal. Your task is to find the minimum number of operations.

Input:
The first line of input contains three integers, N, M, and K, respectively. The next N lines contain M letters each, describing your board.

Output:
Print an integer which represents the minimum number of operations required to achieve your goal. If you cannot achieve your goal, print −1.

Constraints
N,M≤51
K≤1000

Sample input :

2 2 3  
RD  
*L

Sample output :

0

Sample input :

2 2 1  
RD  
*L

Sample output :

1

Explanation :

In the first example, you don't have to change any letter; but in the second example, you should change the letter of cell (1,1) to 'D'.



*/