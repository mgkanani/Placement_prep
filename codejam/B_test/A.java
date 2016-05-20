import java.util.*;
public class A{
	public int cost[];

	A(int[] c){
		cost = c;

	}

	public static void main(String args[]){
		int T=0;
		Scanner sc = new Scanner(System.in);
		String s1 = "Case #";
		T = sc.nextInt();
		int MAX = 1;
     	MAX = MAX<<30;
		for(int i=0;i<T;i++){
			String ret_s = s1+(i+1)+": ";
			int m,n,k;
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			A arr[][] = new A[n+1][n+1];
			int c[] = new int[24];
			arr[0][0] = new A(c);
			//arr[0][0] unsued
			int x,y;
			for(int j=0;j<m;j++){
				// 2 m roads for each pairs.
				x = sc.nextInt();
				y = sc.nextInt();
				c = new int[24];
				for(int iter=0;iter<24;iter++){
					c[iter] = sc.nextInt();
				}
				arr[x][y] = new A(c);
			}
			int s[] = new int[k+1];
			int d[] = new int[k+1];
			int dist[][] = arr[0][0].dijkstra(arr, 1);
			for(int j=0;j<k;j++){
				d[j] = sc.nextInt();
				s[j] = sc.nextInt();
				//System.out.print(dist[s[j]][d[j]]+" ");
				if(MAX<=dist[s[j]][d[j]]){
					ret_s +=("-1 ");
				}else{
					ret_s +=(dist[s[j]][d[j]]+" ");
				}
			}
			System.out.println(ret_s);
			//arr[0][0].printSolution(dist,n);
		}
	}

	int minDistance(int dist[], boolean sptSet[], int time){
   // Initialize min value
		int MAX = 1;
     	MAX = MAX<<30;
   int min = MAX, min_index=0;
   int V= dist.length;
   //A V = new A();
 
   for (int v = 1; v < V; v++)
     if (sptSet[v] == false && dist[v] <= min){
         min = dist[v];
         min_index = v;
     }
 
	   return min_index;
	}
 
	public void printSolution(int dist[][], int n){
		int V = dist[0].length;
		System.out.print("\nNd:-");
		for(int v=2;v<V;v++){
			System.out.print(v+" ");
		}
		System.out.println();
		for(int i=0;i<24;i++){
			System.out.print(i+":-");
			for(int v=2;v<=n;v++){
				System.out.print(dist[i][v]+" ");
			}
			System.out.println();
		}
	}

	public int[][] dijkstra(A graph[][], int src){
		int V=graph.length;
     int dist[][] = new int[24][V];     // The output array.  dist[i] will hold the shortest
                      // distance from src to i
 
     
                     // path tree or shortest distance from src to i is finalized
 
     // Initialize all distances as INFINITE and stpSet[] as false
     int MAX = 1;
     MAX = MAX<<30;

    for (int i = 0; i < 24; i++){
    	for(int j =0;j<V;j++){
    		dist[i][j] = MAX;
    	}
     	//sptSet[i] = false;
     }

 	
     // Distance of source vertex from itself is always 0
     //dist[src] = 0;
 
     // Find shortest path for all vertices
     for(int hr = 0 ;hr<24;hr++){
     	boolean sptSet[] = new boolean[V]; // sptSet[i] will true if vertex i is included in shortest
     	int cur_hr=0;
     	//System.out.println("dist:"+hr+":-");
       	for (int count = 2; count < V; count++)
     	{
     		if(graph[1][count]!=null){
     			dist[hr][count] = graph[1][count].cost[hr];
     			//System.out.print(dist[hr][count]+" ");
     		}else{
     			dist[hr][count] = MAX;
     		}
     		
     	}
     	for (int count = 2; count < V; count++)
     	{
	       // Pick the minimum distance vertex from the set of vertices not
    	   // yet processed. u is always equal to src in first iteration.
	       int u = minDistance(dist[hr], sptSet, hr);
	       //System.out.println("u:-"+u);

 	
       	// Mark the picked vertex as processed
    	   sptSet[u] = true;
 			cur_hr = (dist[hr][u] + hr) % 24;
       // Update dist value of the adjacent vertices of the picked vertex.
	       for (int v = 2; v < V; v++){
	       		if(graph[u][v]!=null && u!=v){
	       			for(int w=0;w<24;w++){
	       				int temp = (cur_hr+w)%24;
	       			if(dist[hr][v] > (w + dist[hr][u] + graph[u][v].cost[temp] ) ) {
	       				dist[hr][v] = w + dist[hr][u] + graph[u][v].cost[temp];
	       			}
	       		}
	       		}else{
	       			// noop.
	       		}
	       }
 
         // Update dist[v] only if is not in sptSet, there is an edge from 
         // u to v, and total weight of path from src to  v through u is 
         // smaller than current value of dist[v]
	       /*
    	     if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX 
                                       && dist[u]+graph[u][v] < dist[v])
        	    dist[hr][v] = dist[hr][u] + graph[u][v];
        	   */
     	}
 	}
 		return dist;
     // print the constructed distance array
     //printSolution(dist, V);
	}
}
