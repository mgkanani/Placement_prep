import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class closestNum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int res=0;
        int t = sc.nextInt();
        int itr=0;
        while(itr<t){
            int a,b,pow,x,r,q;
            a= sc.nextInt();
            b= sc.nextInt();
            x= sc.nextInt();
            pow = (int)Math.pow(a,b);
            if(pow==0 || x==0){
                System.out.println(0);
            }else if(pow<x){
                int temp = Math.min(pow,x-pow);
                System.out.println(temp==pow?0:x);
                //System.out.println(0);
            }else{
                q = pow/x;
                //q = q*x;
                r = q*x;
                int temp = Math.min(pow-r,(r+x)-pow);
                //int cnt=0;
                System.out.println(temp==(pow-r)?r:(r+x));
                //System.out.println(r);
            }
                
            itr++;
        }
    }
}

/*


Problem Statement

You are given 3 numbers a, b and x. You need to output the multiple of x which is closest to ab. If more than one answer exists , display the smallest one.

Input Format
The first line contains T, the number of testcases.
T lines follow, each line contains 3 space separated integers (a, b and x respectively)

Output Format
For each test case , output the multiple of x which is closest to ab

Constraints
1 ≤ T ≤ 105
1 ≤ x ≤ 109
0 < ab ≤ 109
1 ≤ a ≤ 109
-109 ≤ b ≤ 109

Sample Input

3
349 1 4
395 1 7
4 -2 2

Sample Output

348
392
0

Explanation

The closest multiple of 4 to 349 is 348.
The closest multiple of 7 to 395 is 392.
The closest multiple of 2 to 1/16 is 0.

*/