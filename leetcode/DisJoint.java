import java.util.*;

public class UnionFind {
  private int[] _parent;
  private int[] _rank;
  public int find(int i) {
    int p = _parent[i];
    if (i == p) {
      return i;
    }
    return _parent[i] = find(p);
  }


  public void union(int i, int j) {
    int root1 = find(i);
    int root2 = find(j);
    if (root2 == root1) return;
    if (_rank[root1] > _rank[root2]) {
      _parent[root2] = root1;
    } else if (_rank[root2] > _rank[root1]) {
      _parent[root1] = root2;
    } else {
      _parent[root2] = root1;
      _rank[root1]++;
    }
  }


  public UnionFind(int max) {
    _parent = new int[max];
    _rank = new int[max];
    for (int i = 0; i < max; i++) {
      _parent[i] = i;
    }
  }

  
  public String toString() {
    return "<UnionFind\np " + Arrays.toString(_parent) + "\nr " + Arrays.toString(_rank) + "\n>";
  }

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n1,n2;      
      int n = sc.nextInt();
    UnionFind uf = new UnionFind(2*n+1);
      for(int i=0;i<n;i++){
          n1 = sc.nextInt();
          n2 = sc.nextInt();
          uf.union(n1,n2);
      }
      int min=2*n,max=0,cnt=0;
      for(int i=1;i<=2*n;i++){
          cnt=0;
          for(int j=1;j<=2*n;j++){
              if((uf.find(j))==i){
                  cnt++;
              }
          }
          if(cnt>max){max=cnt;}
          if(cnt<min && cnt>1){min=cnt;}
      }
    System.out.println(min+" "+max);  
    //System.out.println(uf);
  }
}
