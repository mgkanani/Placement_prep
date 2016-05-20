import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*

Sansa and XOR



Problem Statement

Sansa has an array. She wants to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained. Can you help her in this task?

Note : [5,7,5] is contiguous subarray of [4,5,7,5] while [4,7,5] is not.

Input Format
First line contains an integer T, number of the test cases.
The first line of each test case contains an integer N, number of elements in the array.
The second line of each test case contains N integers that are elements of the array.

Output Format
Print the answer corresponding to each test case in a separate line.

Constraints
1≤T≤5
2≤N≤105
1≤numbers in array≤108

Sample Input

2
3
1 2 3
4
4 5 7 5

Sample Output

2
0

Explanation

Test case #00:
1⊕2⊕3⊕(1⊕2)⊕(2⊕3)⊕(1⊕2⊕3)=2

Test case #01:
4⊕5⊕7⊕5⊕(4⊕5)⊕(5⊕7)⊕(7⊕5)⊕(4⊕5⊕7)⊕(5⊕7⊕5)⊕(4⊕5⊕7⊕5)=0

*/
public class SansaXor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int itr=0;
        while(itr<T){
            int n = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            if((n&1)==0){
                System.out.println(0);
            }else if(n==1){
                System.out.println(s);
            }else{
                String str[] = s.split(" ");
                int i1=0,i2=0;
                for(i1=0;i1<str.length;i1+=2)
                    i2 = i2 ^ Integer.parseInt(str[i1]);
                //i2 = Integer.parseInt(str[str.length-1]);
                System.out.println(i2);
            }
            itr++;
        }
    }
}