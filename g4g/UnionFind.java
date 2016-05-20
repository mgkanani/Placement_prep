import java.util.*;

public class UnionFind{

	int find(int parent[], int i){
    	if (parent[i] == -1){
    		parent[i] = i;
    		return i;
    	}else if(parent[i] == i){
    		return  i;
    	}else
     		return find(parent, parent[i]);
	}
 
	// A utility function to do union of two subsets 
	boolean union(int parent[], int x, int y){
    	int xset = find(parent, x);
	    int yset = find(parent, y);
	    if(xset==yset)
	    	return true;
    	parent[xset] = yset;
    	return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int parent[] = new int[n+1];
		for(int i=0;i<=n;i++)
			parent[i]=-1;
		int e = sc.nextInt();
		int u,v;
		int i=0;
		UnionFind uni = new UnionFind();
		boolean f = false;
		while(i<e){
			u = sc.nextInt();
			v = sc.nextInt();
			if(uni.union(parent,u,v))
				f=true;
			i++;
		}
		if(f)
			System.out.println("Cycle detected!!");
		else
			System.out.println("Cycle not detected!!");
	}
}