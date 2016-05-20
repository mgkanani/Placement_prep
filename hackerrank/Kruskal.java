import java.util.*;
public class Kruskal{
/*
Custom sort example.

*/

	static boolean dbg = false;
	public static void PRINT(Object arg) { System.out.print(arg); }
	public static void PRINTLN(Object arg) { System.out.println(arg); }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int i,j;
		List<Edge> list = new ArrayList<Edge>();
		HashMap<String,Edge> map = new HashMap<String,Edge>();
		int x,y,val;
		Edge e = null;
		for(i=0;i<m;i++){
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
			val = sc.nextInt();
			if(map.containsKey(x+"#"+y)) {
				e = map.get(x+"#"+y);
				if(e.cost>val){
					list.remove(e);
					e = new Edge(x,y,val);
					map.put(x+"#"+y,e);
					list.add(e);
				}
			} else if(map.containsKey(y+"#"+x)) {
				e = map.get(y+"#"+x);
				if(e.cost>val){
					list.remove(e);
					e = new Edge(x,y,val);
					map.put(y+"#"+x,e);
					list.add(e);
				}
			} else {
				e = new Edge(x,y,val);
				map.put(x+"#"+y,e);
				list.add(e);
			}
		}
		// custom sorting
		Collections.sort(list,new Edge());

		if(Kruskal.dbg){
			for(Edge e1 : list){
				PRINT(e1.u+"-"+e1.v+":"+e1.cost+"\n");
			}
		}
		int src = sc.nextInt();
		int cost = mst(list,src,n);
		PRINTLN(cost);
	}

	public static int mst(List<Edge> list, int src, int n){
		int cost = 0;
		List<HashSet<Integer>> ll = new ArrayList<HashSet<Integer>>();
		//HashSet<Integer> set = new HashSet<Integer>();
		Edge cur = null;
		HashSet<Integer> t1=null,t2=null;
		int pos = 1;
		if(list.size()>0){
			cur = list.get(0);
			t2 = new HashSet<Integer>();
			t2.add(cur.u);
			t2.add(cur.v);
			ll.add(t2);
			cost += cur.cost;
		}
		while(((HashSet<Integer>)ll.get(0)).size()<n && pos<list.size()){
			cur = list.get(pos);
			pos++;
			t1 = find(cur.u, ll);
			t2 = find(cur.v, ll);
			if(t1==t2){
				if(t1==null){
					t2 = new HashSet<Integer>();
					t2.add(cur.u);
					t2.add(cur.v);
					ll.add(t2);
					cost += cur.cost;
				}
			}else if(t1==null){ t2.add(cur.u); cost += cur.cost;
			}else if(t2==null){ t1.add(cur.v); cost += cur.cost;
			}else{
				ll.remove(t1);
				Iterator iter = t1.iterator();
				while(iter.hasNext()){
					t2.add((Integer)iter.next());
				}
				cost += cur.cost;
			}
			if(Kruskal.dbg)
				PRINTLN(t1 +"\t"+t2);
		}
		if(Kruskal.dbg)
			PRINTLN((HashSet<Integer>)ll.get(0));
		return cost;
	}

	public static HashSet<Integer> find(int u, List<HashSet<Integer>> ll){
		HashSet<Integer> ret = null;
		for(HashSet<Integer> set : ll){
			if(set.contains(u)){
				return set;
			}
		}
		return ret;
	}
}


class Edge implements Comparator<Edge>{
	int cost;
	int u,v;
	Edge(){}
	Edge(int x, int y, int c){
		cost = c;
		u = x;
		v = y;
	}
	public int compare(Edge e1, Edge e2){
		if(e1.cost==e2.cost){
			return (e1.u+e1.v) - (e2.u+e2.v);
		}else {
			return e1.cost-e2.cost;
		}
    }
}