import java.util.*;
public class UnionFindII{
	int _p[];
	int cnt;

	UnionFindII(int n){
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

    public String toString() {
    	return "<UnionFindII\n_p " + Arrays.toString(_p) + "\ncnt "+cnt+"\n>";
	}

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        UnionFindII uf = new UnionFindII(2*N);
        int i=0,u,v;
        for(i=0;i<N;i++){
            u = sc.nextInt();
            v = sc.nextInt();
            uf.union(u-1,v-1);
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(i=0;i<2*N;i++){
            u = uf.find(i);
            v=0;
            if(map.containsKey(u)){
                v = map.get(u);
            }
            map.put(u,v+1);
        }
        TreeSet<Integer> tree = new TreeSet<Integer>(map.values());
        int first=0,last=tree.last();
        while(!tree.isEmpty()){
            first = tree.pollFirst();
            if(first>1)
                break;
        }
        System.out.println(first+" "+last);
        
    }
}

/*

Components in a graph



Problem Statement

There are 2N values to represent nodes in a graph. They are divided into two sets G and B. Each set has exactly N values. Set G is represent by {G1,G2,⋯,GN}. G can take any value between 1 to N(inclusive). Set B is represented by {B1,B2,⋯,BN}. B can take any value between N+1 to 2N(inclusive). Same value can be chosen any number of times.

Here (G1,B1),(G2,B2),⋯(GN,BN) represents the edges of the graph.

Your task is to print the number of vertices in the smallest and the largest connected components of the graph.

Note Single nodes should not be considered in the answer.

For more clarity look at the following figure.

Alt text

For the above graph smallest connected component is 7 and largest connected component is 17.

Input Format

First line contains an integer N.
Each of the next N lines contain two space-separated integers, ith line contains Gi and Bi.

Constraints
1≤N≤15000
1≤Gi≤N
N+1≤Bi≤2N

Output Format

Print two space separated integers, the number of vertices in the smallest and the largest components.

Sample Input

5
1 6 
2 7
3 8
4 9
2 6

Sample Output

2 4

Explanation

The number of vertices in the smallest connected component in the graph is 2 i.e. either (3,8) or (4,9).
The number of vertices in the largest connected component in the graph is 4 i.e. 1−2−6−7.


*/