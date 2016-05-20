//this is the main method that calls the helper DFS which runs on each node
import java.util.*;

public class Code1{
  boolean visited[];
  int arr[];
  int val[];
  int n;
  float res;

  public Code1(boolean v[], int matrix[], int val[]){
    visited = v;
    arr = matrix;
    this.val= val;
    n= matrix.length;
    res=0;
  }

public float allCyclesDirectedmain(){
    //this initializes all vertices
    //clearAll();
    int[] count = new int[1];
    float[] res = new float[1];
    float[] cur = new float[1];
    res[0] = 0;
    for(int i=0;i<n;i++){
    //for (Vertex v: vertexMap.values()){
        //System.out.println(v.name);
        //clearAll();
        cur[0] = 1f;
        dfs(i,i,count,cur,res);
        visited[i] = true;
    }
    //System.out.println();
    return count[0]==0?0:res[0];///count[0];
  }

//start and v are same when the method first fires.
public void dfs(int start, int v,int[] count, float[] cur, float []res){
   if (visited[v]){
       if (start==v){
           //found a path
          res[0]+=cur[0];
           count[0]++;
       }
       return ;
   }
   visited[v] = true;
   cur[0]=(cur[0]*val[v])/100;
   //System.out.println(v+"\t"+cur[0]);
   dfs(start,arr[v],count,cur,res);
   /*
   for (Edge e : v.adj){
       Vertex next = e.target;
       dfs(start,next,count);
   }*/
   visited[v]= false;
}

  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int i = 0;
    int arr[] = new int[n];
    int val[] = new int[n];
    boolean visited[] = new boolean[n];
    for(i=0;i<n;i++){
      arr[i] = sc.nextInt()-1;
      val[i] = sc.nextInt();
      if(arr[i]==i){
        val[i] = 0;
      }
      visited[i]=false;
    }
    Code1 code = new Code1(visited,arr,val);
    String s = String.format("%.2f", code.allCyclesDirectedmain());
    System.out.println(s);
  }

}