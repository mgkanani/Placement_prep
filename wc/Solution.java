import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),Q=sc.nextInt();
        int a[] = new int[N+1];
        int b[] = new int[N+1];
        //long temp1[] = new long[N+1];
        //long temp2[] = new long[N+1];
        int i,j;
        long sum=0;
        long mod = 1000000007;
        byte cmd = 0;
        int l=0,r=0,c=0;
        long t_long=0;
        StringBuilder br = new StringBuilder(Q*12);
        for(i=0;i<Q;i++){
            cmd = sc.nextByte();
            switch(cmd){
                case 1:
                        //array a increment by c
                        l = sc.nextInt();
                        r = sc.nextInt();
                        c = sc.nextInt();
                        a[l-1] += c;
                        a[r] -= c;
                        break;
                case 2:
                        //array b increment by c
                        l = sc.nextInt();
                        r = sc.nextInt();
                        c = sc.nextInt();
                        b[l-1] += c;
                        b[r] -= c;
                        break;
                
                case 3:
                        // print result
                        l = sc.nextInt();
                        r = sc.nextInt();
                        //temp1[0] = a[0];
                        //temp2[0] = b[0];
                        for(j=1;j<r;j++){
                            //temp1[j] = temp1[j-1]+a[j];
                            a[j] = a[j-1]+a[j];
                            b[j] = b[j-1]+b[j];
                            //System.out.print(temp2[j-1]+" ");
                        }
                            //System.out.println(temp2[j-1]);
                        sum=0;
                        for(j=l-1;j<r;j++){
                            sum+=((long)a[j]*b[j]);
                            //sum = sum % mod;
                        }
                        sum = sum % mod;
                        br.append(sum+"\n");
                        break;
            }
        }
        System.out.println(br);
    }
}
