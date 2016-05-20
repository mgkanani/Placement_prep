import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
nCr table



Problem Statement

Jim is doing his discrete maths homework which requires him to repeatedly calculate nCr(n choose r) for different values of n. Knowing that this is time consuming, he goes to his sister June for help. June, being a computer science student knows how to convert this into a computer program and generate the answers quickly. She tells him, by storing the lower values of nCr(n choose r), one can calculate the higher values using a very simple formula.

If you are June, how will you calculate nCr values for different values of n?

Since nCrvalues will be large you have to calculate them modulo 109.

Input Format
The first line contains the number of test cases T.
T lines follow each containing an integer n.

Output Format
For each n output the list of nC0 to nCn each separated by a single space in a new line. If the number is large, print only the last 9 digits. i.e. modulo 109

Constraints
1<=T<=200
1<=n< 1000

Sample Input

3
2
4
5

Sample Output

1 2 1
1 4 6 4 1
1 5 10 10 5 1

Explanation
For 2 we can check 2C0 2C1 and 2C2 are 1, 2 and 1 respectively. The other inputs' answer follow similar pattern.

*/
public class nCrTable {
    static int table[][];
    static int mod = (int)1e9;
	public static void ncr(){
		table = new int[1001][1001];
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++)
                table[i][j]=-1;
        }
        for(int i=0;i<1001;i++)
		  calc(1000,i);
		//return table[n][r];
	}
	static void calc(int n, int r){
		if(n==r || r==0){
			table[n][r] =1;
			return;
		}
		if(n<r){
			table[n][r]=0;
			return;
		}else{
			if(table[n-1][r-1]==-1){
				calc(n-1,r-1);
			}
			if(table[n-1][r]==-1){
				calc(n-1,r);
			}
			table[n][r]=(table[n-1][r-1]+table[n-1][r])%mod;
			return;
		}
			
	}
    public static String print(int n){
        StringBuilder br = new StringBuilder(n*1000);
        for(int i=0;i<=n;i++){
            br.append(table[n][i]+" ");
        }
        br.append("\n");
        return br.toString();
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ncr();
        int i=0;
        StringBuilder br = new StringBuilder(1000*t);
        while(i<t){
            int n = sc.nextInt();
            br.append(print(n));
            i++;
        }
        System.out.print(br);
    }
}