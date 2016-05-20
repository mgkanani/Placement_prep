import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoStrings {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int itr=0;
        String s1,s2;
        boolean a1[],a2[];
        int i;
        while(itr<T){
            s1 = sc.next();
            s2 = sc.next();
            i=0;
            a1 = new boolean[26];
            //a2 = new boolean[26];
            while(i<s1.length()){
                a1[s1.charAt(i)-'a']=true;
                i++;
            }
            i=0;
            while(i<s2.length()){
                if(a1[s2.charAt(i)-'a']){
                    System.out.println("YES");
                    break;
                }
                i++;
            }
            if(i==s2.length()){
                System.out.println("NO");
            }
            itr++;
        }
    }
}
/*
You are given two strings, A and B. Find if there is a substring that appears in both A and B.

Input Format

Several test cases will be given to you in a single file. The first line of the input will contain a single integer T, the number of test cases.

Then there will be T descriptions of the test cases. Each description contains two lines. The first line contains the string A and the second line contains the string B.

Output Format

For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.

Constraints

All the strings contain only lowercase Latin letters.
1<=T<=10
1<=|A|,|B|<=105
Sample Input

2
hello
world
hi
world

Sample Output

YES
NO

Explanation

For the 1st test case, the letter o is common between both strings, hence the answer YES.
For the 2nd test case, hi and world do not have a common substring, hence the answer NO.
*/