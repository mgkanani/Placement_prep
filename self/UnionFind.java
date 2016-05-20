import java.util.*;
public class UnionFind{
	int _p[];
	int cnt;

	UnionFind(int n){
		cnt=n;
		_p = new int[n];
		for(int i=0;i<n;i++){
			_p[i]=i;
		}
	}

	int find(int c){
		int parent = _p[c];
		if(c==parent){
			return c;
		}
		return _p[c] = find(parent);
	}

	void union(int u, int v){
		int p1 = find(u);
		int p2 = find(v);
		if(p1==p2){
			//cycle detected.
			return;
		}
		cnt--;// 2 different groups are merged.
		_p[v] = p1;
		_p[p2] = p1; // set parent of `parent of v` to `parent of u`
		//mergeAll(p2,p1);
	}
	
	void mergeAll(int old_p, int new_p){
		//int p1 = find();
		for(int i=0;i<_p.length;i++){
			if(_p[i]==old_p){
				_p[i] = new_p;
			}
		}
	}
	
	public String toString() {
    	return "<UnionFind\n_p " + Arrays.toString(_p) + "\ncnt "+cnt+"\n>";
	}

	public static void main(String[] args) {
	   UnionFind uf = new UnionFind(6);
	    System.out.println(uf);
/*
	    uf.union(1,2);
	    System.out.println("union 1 2");
	    System.out.println(uf);
*/
	    uf.union(2,4);
	    System.out.println("union 2 4");
	    System.out.println(uf);

		uf.union(1,5);
	    System.out.println("union 1 5");
	    System.out.println(uf);

	    uf.union(1,2);
	    System.out.println("union 1 2");
	    System.out.println(uf);

	    uf.union(3,4);
	    System.out.println("union 3 4");
	    System.out.println(uf);

	    uf.union(1,0);
	    System.out.println("union 1 0");
	    System.out.println(uf);

	    uf.union(4,5);
	    System.out.println("union 4 5");
	    System.out.println(uf);

	    uf.find(3);
	    System.out.println("find 4");
	    System.out.println(uf);

	}
}