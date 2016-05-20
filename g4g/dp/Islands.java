import java.util.*;
/*

Find the number of islands

Given a boolean 2D matrix, find the number of islands.

This is an variation of the standard problem: “Counting number of connected components in a undirected graph”.

Before we go to the problem, let us understand what is a connected component. A connected component of an undirected graph is a subgraph in which every two vertices are connected to each other by a path(s), and which is connected to no other vertices outside the subgraph.
For example, the graph shown below has three connected components. 
A graph where all vertices are connected with each other, has exactly one connected component, consisting of the whole graph. Such graph with only one connected component is called as Strongly Connected Graph.

The problem can be easily solved by applying DFS() on each component. In each DFS() call, a component or a sub-graph is visited. We will call DFS on the next un-visited component. The number of calls to DFS() gives the number of connected components. BFS can also be used.

What is an island?
A group of connected 1s forms an island. For example, the below matrix contains 5 islands

	                {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}

A cell in 2D matrix can be connected to 8 neighbors. So, unlike standard DFS(), where we recursively call for all adjacent vertices, here we can recursive call for 8 neighbors only. We keep track of the visited 1s so that they are not visited again.
*/
public class Islands{
	static int rows[] = {-1,0,1,0,-1,1,-1,1};
	static int cols[] = {0,-1,0,1,-1,1,1,-1};
	static int len = rows.length;	
	public static void main(String[] args) {
		int arr[][]= {  {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
 	   };
 	   int cnt=0;
 	   for(int i=0;i<arr.length;i++)
 	   		for(int j=0;j<arr[0].length;j++){
 	   			if(arr[i][j]==1){
 	   				cnt++;
 	   				setZero(arr,i,j);
 	   			}
 	   		}
 	   	System.out.println(cnt);
	}
	public static void setZero(int[][] arr,int i, int j) {
		if(i<0||j<0||i>=arr.length || j>=arr[0].length)
			return;
		arr[i][j]=0;
		int ni=0,nj=0;
		for(int i1=0;i1<len;i1++){
		    ni=i+rows[i1];
		    nj=j+cols[i1];
			if((ni<arr.length && ni>=0) && (nj<arr[0].length && nj>=0) && arr[ni][nj]==1){
				setZero(arr,ni,nj);
			}
		}
/*		for(int i1=0;i1<8;i1++){
			for(int j1=0;j1<8;j1++){
				if(((i+rows[i1])<arr.length && (i+rows[i1])>=0) && ((j+cols[j1])<arr[0].length && (j+cols[j1])>=0)){
					if(arr[i+rows[i1]][j+cols[j1]]==1)
						setZero(arr,i+rows[i1],j+cols[j1]);
				}
			}
		}
*/	}
}