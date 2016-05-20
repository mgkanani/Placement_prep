import java.util.*;
public class WordLadder {
	public static void main(String[] args) {
		WordLadder word = new WordLadder();
		System.out.println(word.comp("hit","hoo"));
	}
    public int ladderLength(String begin, String end, Set<String> dict) {
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(dict);
        int len = dict.size();
        int arr[][] = new int[len][len];
        int src = list.indexOf(begin);
        int dest = list.indexOf(end);
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(comp(list.get(i),list.get(j))){
                    arr[i][j] = 1;
                    arr[j][i] = 1;
                }
            }
        }
        dij(arr,src,dest);
        /*
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        */
        return 0;
    }
    public boolean comp(String s1, String s2){
        int diff=0;
        int i=0;
        while(i<s1.length() && diff<2){
            if(s1.charAt(i)!=s2.charAt(i))
                diff++;
            i++;
        }
        return diff<2;
    }

   public static void dij(int paths[][], int src, int dest){
        int n = paths.length;
        int dis[] = new int[n];
        boolean vis[] = new boolean[n];
        int MAX = 1;
        MAX = MAX<<29;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(paths[i][j]==0)
                    paths[i][j]=MAX;
            }
        }
        for(int i=0;i<n;i++){
            paths[i][i]=0;
            dis[i] = paths[src][i];
            //System.out.println(vis[i]);
        }
        vis[src]=true;
        for(int i=1;i<n;i++){
            int v = findmin(dis,vis);
            vis[v] = true;
            for(int j=0;j<n;j++){
                if(j!=src && paths[v][j]<MAX && dis[j]>(dis[v]+paths[v][j])){
                    //paths[src][j]=(paths[src][v]+paths[v][j]);
                    dis[j] = dis[v]+paths[v][j];
                }
            }
        }
        
        System.out.println(dis[dest]);
        /*
        for(int i=0;i<n;i++){
            if(i!=src){
                System.out.print((dis[i]>=MAX?-1:dis[i])+" ");
            }
        }*/
    }
    
    public static int findmin(int []dis, boolean []vis){ 
        int MAX = 1;
        MAX = MAX<<29;
        int min=MAX,ind=0;
        for(int i=0;i<dis.length;i++){
            if(!vis[i] && min>dis[i]){
                min = dis[i];
                ind=i;
            }
        }
        return ind;
    }
}