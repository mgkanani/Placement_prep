/*

Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1

Given an n x n matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the given 2D array.

For example, consider the following 2D array.

        10, 20, 30, 40
        15, 25, 35, 45
        24, 29, 37, 48
        32, 33, 39, 50
The 3rd smallest element is 20 and 7th smallest element is 30

We strongly recommend to minimize the browser and try this yourself first.

The idea is to use min heap. Following are detailed step.
1) Build a min heap of elements from first row. A heap entry also stores row number and column number.
2) Do following k times.
…a) Get minimum element (or root) from min heap.
…b) Find row number and column number of the minimum element.
…c) Replace root with the next element from same column and min-heapify the root.
3) Return the last extracted root.

Following is C++ implementation of above algorithm.

*/

import java.util.*;

class MyClass{
	int val;
	int row,col;
	MyClass(int v, int r, int c){
		val = v;
		col = c;
		row = r;
	}
}

public class KthSmall{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][]={{10, 20, 30, 40},
                    {15, 25, 35, 45},
                    {25, 29, 37, 48},
                    {32, 33, 39, 50},
		};
		int n = arr.length;
		PriorityQueue<MyClass> minh = new PriorityQueue<MyClass>(n,new Comparator<MyClass>(){
			public int compare(MyClass c1, MyClass c2){
				return c1.val - c2.val;
			}
		});
		for(int i=0;i<n;i++){
			minh.add(new MyClass(arr[0][i],0,i));
		}
		int k = sc.nextInt();
		MyClass m1=null;
		int c1;
		while(k>0){
			m1 = minh.remove();
			c1 = m1.row;
			if(c1+1<n){
				minh.add(new MyClass(arr[c1+1][m1.col],c1+1,m1.col));
			}
			k--;
		}
		System.out.println(m1.val);
	}
}