import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*

Two Strings

Problem Statement

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
public class CommonLetter {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        //sc.next();
        String s1,s2;
        int i=0;
        boolean f=false;
        boolean ch[] = null;
        while(i<T){
            f=false;
            ch = new boolean[26];
            s1 = sc.nextLine();
            s2 = sc.nextLine();
            //System.out.println(s1+"\t"+s2);
            for(char c: s1.toCharArray()){
                ch[c-'a']=true;
            }
            for(char c: s2.toCharArray()){
                if(ch[c-'a']){
                    System.out.println("YES");
                    f=true;
                    break;
                }
            }
            if(!f){
                System.out.println("NO");
            }
            i++;
        }
    }
}