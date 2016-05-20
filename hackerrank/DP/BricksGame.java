import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Min max game. 

Bricks Game

*/
public class BricksGame {
    static long memo[];
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int itr = 0;
        while(itr<t){
            int n = sc.nextInt();
            int arr[] = new int[n];
            memo = new long[n];
            int i,j;
            for(i=0;i<n;i++){
                arr[i] = sc.nextInt();
                memo[i]=-1;
            }
            proc(arr,0);
            /*
            for(i=0;i<n;i++){
                System.out.print(memo[i]+" ");
            }
            System.out.println("\n"+memo[0]);
            */
            System.out.println(memo[0]);
            itr++;
        }
    }
    public static long proc(int[] arr, int i){
        if(i>=arr.length)
            return 0;
        else if(i>=arr.length-3){
            long v1=0;
            for(int j=i;j<arr.length;j++)
                v1 += arr[j];
            memo[i] = v1;
            return v1;
        }
        else if(memo[i]!=-1)
            return memo[i];
        else{
            //proc(arr,i+1);
            long v1=0,v2=0,v3=0;
            long m2,m3,m4,m5,m6;
            m2 = proc(arr,i+2);
            m3 = proc(arr,i+3);
            m4 = proc(arr,i+4);
            m5 = proc(arr,i+5);
            m6 = proc(arr,i+6);
            v1 = arr[i] + Math.min(m2, Math.min(m3,m4));
            v2 = arr[i] + arr[i+1] + Math.min(m3, Math.min(m4,m5));
            v3 = arr[i] + arr[i+1] + arr[i+2] + Math.min(m4, Math.min(m5,m6));
            memo[i] = Math.max(v1,Math.max(v2,v3));
        }
        return memo[i];
    } 
}