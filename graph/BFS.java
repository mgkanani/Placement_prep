import java.util.*;
public class BFS{
//for undirected graph
/*
	extra condition for undirected is:- check whether current element has not been already inserted into queue.

	If it is already inserted then there is a cycle in the graph and we already considered it.
*/
	public int[] bfs(int matrix[][], int start){
                int n = matrix.length;
                boolean visited[] = new boolean[n];
                LinkedList<Integer> q = new LinkedList<Integer>();
                //List<Integer> list = new ArrayList<Integer>();
                int result[] = new int[n];
                int i=0;
                //for(i=1;i<n;i++){
                //      result[i]=-1;
                //}
                //for(i=0;i<m;i++)
                result[start] = 0;
                visited[start] = true;
                q.add(start);
                int u=0,v=0;
                int size = 0, cnt=0;
                int cost = 6;
                while(!q.isEmpty()){
                        size = q.size();
                        cnt=0;
                        while(cnt<size && !q.isEmpty()){
                                u = q.poll();
                                visited[u] = true;
                                System.out.println(u);
                                for(i=1;i<n;i++){
                                        if(!visited[i] && matrix[u][i]!=0 && !q.contains(i)){
                                                q.add(i);
                                                result[i]+=cost;
                                        }
                                }
                                cnt++;
                        }
                        cost+=6;
                }
                for(i=1;i<n;i++){
                        //System.out.println(result[i]);
                }
                return result;
	}
/*
2-color or bipartite problems can be solved using this.


*/

/*
	boolean isCyclic(int matrix[][], int start){
		//for undirected graph
                int n = matrix.length;
                boolean visited[] = new boolean[n];
                LinkedList<Integer> q = new LinkedList<Integer>();
                //List<Integer> list = new ArrayList<Integer>();
                int i=0;
                visited[start] = true;
                q.add(start);
                int u=0,v=0;
                int size = 0, cnt=0;
                while(!q.isEmpty()){
                        size = q.size();
                        cnt=0;
                        while(cnt<size && !q.isEmpty()){
                                u = q.poll();
                                visited[u] = true;
                                //System.out.println(u);
                                for(i=1;i<n;i++){
                                        if(!visited[i] && matrix[u][i]!=0){
                                        	if(q.contains(i)){
                                        		//cycle detected.
                                        		return true;
                                        	}
                                        	matrix[i][u]=0;
                                            q.add(i);
                                        }
                                }
                                cnt++;
                        }
                }
                return false;
	}

	public int[] topological(int matrix[][], int start){
		// for ordered graph
                int n = matrix.length;
                boolean visited[] = new boolean[n];
                LinkedList<Integer> q = new LinkedList<Integer>();
                //List<Integer> list = new ArrayList<Integer>();
                int result[] = new int[n];
                int i=0;
                //for(i=1;i<n;i++){
                //      result[i]=-1;
                //}
                //for(i=0;i<m;i++)
                result[start] = 0;
                visited[start] = true;
                q.add(start);
                int parent[] = new int[n];
                int u=0,v=0;
                int size = 0, cnt=0;
                int cost = 6;
                while(!q.isEmpty()){
                        size = q.size();
                        cnt=0;
                        while(cnt<size && !q.isEmpty()){
                                u = q.poll();
                                visited[u] = true;
                                //System.out.println(u);
                                for(i=1;i<n;i++){
                                		if(visited[i] && matrix[u][i]!=0){
                                			System.out.println("cycle detected!!");
                                		}
                                        if(!visited[i] && matrix[u][i]!=0){
                                                q.add(i);
                                                result[i]+=cost;
                                        }
                                }
                                cnt++;
                        }
                        //cost+=6;
                }
                for(i=1;i<n;i++){
                        //System.out.println(result[i]);
                }
                return result;
	}

	*/
	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        BFS bfs = new BFS();
        int t=0,j=0;
        t = sc.nextInt();
        for(j=0;j<t;j++){
        	int n,m;
	        n = sc.nextInt();
    	    m = sc.nextInt();
        	int matrix[][] = new int[n+1][n+1];
	        int i=0,u,v;
    	    for(i=0;i<m;i++){
        	    u = sc.nextInt();
            	v = sc.nextInt();
	            matrix[u][v] = 1;
    	        matrix[v][u] = 1;
        	}
        	int s = sc.nextInt();
        	//System.out.println(bfs.isCyclic(matrix,s));
    	}
	}
}