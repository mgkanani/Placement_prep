import java.util.*;
/*
Problem Statement

There are N buildings in a certain one-dimensional landscape. Each building has a height given by hi,i∈[1,N]. If you join K adjacent buildings, they will form a solid rectangle of area K×min(hi,hi+1,…,hi+k−1).

Given N buildings, find the greatest such solid area formed by consecutive buildings.

Input Format
The first line contains N, the number of buildings altogether.
The second line contains N space-separated integers, each representing the height of a building.

Constraints
1≤N≤105
1≤hi≤106

Output Format
One integer representing the maximum area of rectangle formed.

Sample Input

5
1 2 3 4 5

Sample Output

9
*/
public class LargestRect {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(process(arr));
    }
    public static int process(int[] arr){
        Stack<Integer> st = new Stack<Integer>();
        int max=0;
        int last_i=0,val,area,range;
        int i=0;
        for(i=0;i<arr.length;i++){
            if(st.isEmpty() || arr[st.peek()]<arr[i])
                st.push(i);
            else{
                last_i=st.peek();
                while(arr[last_i]>arr[i]){
                    last_i=st.pop();
                    val = arr[last_i];
                    //System.out.println("val:-"+val);
                    range = st.isEmpty()?i:(i-st.peek()-1);
                    area = range*val;
                    if(max<area)
                        max=area;
                    if(!st.isEmpty())
                        last_i=st.peek();
                    else
                        break;
                }
                st.push(i);
                //System.out.println("push:-"+arr[i]+"\t"+st.size());
            }
        }
        while(!st.isEmpty()){
            
            last_i=st.pop();
           // System.out.println(arr[last_i]);
                    val = arr[last_i];
                    range = st.isEmpty()?i:(i-st.peek()-1);
                    area = range*val;
                    if(max<area)
                        max=area;
        }
        return max;
    }
}