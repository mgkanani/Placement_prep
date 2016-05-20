import java.util.*;
/* 
topological sort can be obtained by reversing the elements stored into stack "st".

*/
public class DFS{
	Stack<Integer> st;
	boolean vis[];
	int edge[][];
	int n;
	DFS(int n, int matrix[][]){
		st = new Stack<Integer>();
		vis = new boolean[n+1];
		for(int i=0;i<=n;i++)
			vis[i]=false;
		this.edge = matrix;
		this.n = n;
	}

	void dfs(int x){
		vis[x] = true;
		for(int i=1;i<=n ;i++){
			if(!vis[i] && edge[x][i]!=0){

				dfs(i);
			}
		}
		//System.out.println(x);
		st.push(x);
	}

	void topological(){
		//int i=0;
		while(!st.isEmpty()){
			System.out.print(st.pop()+" ");
		}
		
	}

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t=0,j=0;
        //t = sc.nextInt();
        //for(j=0;j<t;j++){
        int n,m;
        n = sc.nextInt();
        DFS dfs ;//= new DFS(n);

        m = sc.nextInt();
        int matrix[][] = new int[n+1][n+1];
        int i=0,u,v;
        for(i=0;i<m;i++){
            u = sc.nextInt();
            v = sc.nextInt();
            matrix[u][v] = 1;
            //matrix[v][u] = 1;
        }
        dfs = new DFS(n,matrix);
        int s = sc.nextInt();
        dfs.dfs(s);
        if(!dfs.isCycle())
        	dfs.topological();
        //System.out.println(dfs.dfs(s));
	}


	public boolean isCycle(){
		return true;
	}

}