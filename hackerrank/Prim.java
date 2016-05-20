import java.util.*;
public class Prim{
	static boolean dbg = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int T = sc.nextInt();
		//for(int iter=0;iter<T;iter++){
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			int i,j,k;
			int m,temp=0,x,y;
			m = sc.nextInt();
			for(i=0;i<n;i++){
				for(j=0;j<n;j++){
					arr[i][j] = Integer.MAX_VALUE;
				}
			}
			for(i=0;i<m;i++){
				x = sc.nextInt()-1;
				y = sc.nextInt()-1;
				temp = sc.nextInt();
				if(temp < arr[x][y]){
					arr[x][y] = temp;
					arr[y][x] = temp;
				}
			}
			if(Prim.dbg){
			for(i=0;i<n;i++){
				for(j=0;j<n;j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		    }
			int src = sc.nextInt()-1;
			int cost = prim(arr,src);
			System.out.println(cost);
		//}
	}

	public static int prim(int arr[][], int src){
		int i,j=0,k,n=arr.length;
		int cost = 0;
		int edges[][] = new int[n-1][2];
		//int MAX = 1;
		//MAX = MAX<<29;
		int min = Integer.MAX_VALUE;
		int ind = src;
		for(i=0;i<n;i++){
			if(min>arr[src][i]){
				min = arr[src][i];
				ind = i;
			}
		}
		//boolean vis[] = new boolean[n];
		//vis[src] = true;
		//vis[ind] = true;
		edges[0][0] = src;
		edges[0][1] = ind;
		cost +=min;
		int near [] = new int[n];
		//update near
		for(i=0;i<n;i++){
			if(arr[src][i]<arr[ind][i])
				near[i] = src;
			else
				near[i] = ind;
		}
		near[src] = -1; // As Node is starts from 0 instead of 1.
		near[ind] = -1;
		if(Prim.dbg)
			System.out.println("\t src="+src+"\t next="+ind);
		for(i=1;i<n-1;i++){
			//find nearest vertex for current tree.
			j=src;
			min = Integer.MAX_VALUE;
			for(k=0;k<n;k++){
				if(near[k]!=-1 && min > arr[k][near[k]]){
					min =  arr[k][near[k]];
					j = k;
				}
			}
			if(Prim.dbg)
				System.out.println("\t u="+near[j]+"\t v="+j +"\t cost"+min);
			//System.out.println("\t j="+j);
			near[j] = -1;
			cost += min;
			edges[i][0] = near[j];
			edges[i][1] = j;
			//update near array.
			for(k=0;k<n;k++){
				if(near[k]!=-1 && (arr[k][near[k]] > arr[j][k]))
					near[k] = j;
			}

		}
		return cost;
	}
}