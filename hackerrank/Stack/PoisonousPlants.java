import java.util.*;

class Pair{
    int val;
    int cnt;
    Pair(int v,int c){val=v;cnt=c;}
}
/*
Poisonous Plants

Problem Statement

There are N plants in a garden. Each of these plants has been added with some amount of pesticide. After each day, if any plant has more pesticide than the plant at its left, being weaker than the left one, it dies. You are given the initial values of the pesticide in each plant. Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.

Input Format

The input consists of an integer N. The next line consists of N integers describing the array P where P[i] denotes the amount of pesticide in plant i.

Constraints
1≤N≤100000
0≤P[i]≤109

Output Format

Output a single value equal to the number of days after which no plants die.

Sample Input

7
6 5 8 4 7 10 9

Sample Output

2

Explanation

Initially all plants are alive.
Plants = {(6,1), (5,2), (8,3), (4,4), (7,5), (10,6), (9,7)}
Plants[k] = (i,j) => jth plant has pesticide amount = i.
After the 1st day, 4 plants remain as plants 3, 5, and 6 die.
Plants = {(6,1), (5,2), (4,4), (9,7)}
After the 2nd day, 3 plants survive as plant 7 dies. Plants = {(6,1), (5,2), (4,4)}
After the 3rd day, 3 plants survive and no more plants die.
Plants = {(6,1), (5,2), (4,4)}
After the 2nd day the plants stop dying.

complexity O(n).
*/

public class PoisonousPlants {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Stack<Integer> st = new Stack<Integer>();
        int i=0;
        int arr[] = new int[n];
        while(i<n){
            arr[i] = sc.nextInt();
            i++;
        }
        int days=0,t1=0;
        Stack<Pair> st1 = new Stack<Pair>();
        i--;
        st1.push(new Pair(arr[i],0));
        while(i>0){
            i--;
            t1=0;
            while(!st1.isEmpty() && arr[i]<st1.peek().val){
                t1 = Math.max(st1.peek().cnt,t1+1);
                st1.pop();
            }
            days = Math.max(t1,days);
            st1.push(new Pair(arr[i],t1));
        }
        System.out.println(days);
    }
}