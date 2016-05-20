import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void dij(int paths[][], int src){
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
        
        for(int i=0;i<n;i++){
            if(i!=src){
                System.out.print((dis[i]>=MAX?-1:dis[i])+" ");
            }
        }
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
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int paths[][] = new int[n][n];
            int x,y;
            int temp=0;
            for(int j=0;j<m;j++){
                x = sc.nextInt()-1;
                y = sc.nextInt()-1;
                temp = sc.nextInt();
                if(paths[x][y]==0 || paths[x][y]>temp){
                paths[x][y] = temp;
                paths[y][x] = temp;
                }
            }
            m = sc.nextInt()-1;
            dij(paths,m);
            System.out.println();
        }
    }
}
/*

Dijkstra: Shortest Reach 2

Problem Statement

Given a graph consisting N nodes (labelled 1 to N) where a specific given node S represents the starting position S and an edge between two nodes is of a given length, which may or may not be equal to other lengths in the graph.

It is required to calculate the shortest distance from the start position (Node S) to all of the other nodes in the graph.

Note 1: If a node is unreachable , the distance is assumed as −1.

Input Format

The first line contains T, denoting the number of test cases.
First line of each test case has two integers N, denoting the number of nodes in the graph and M, denoting the number of edges in the graph.

The next M lines each consist of three space-separated integers x y r, where x and y denote the two nodes between which the undirected edge exists, r denotes the length of edge between these corresponding nodes.

The last line has an integer S, denoting the starting position.

Constraints
1≤T≤10
2≤N≤3000
1≤M≤N×(N−1))2
1≤x,y,S≤N
1≤r≤350

If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.

Output Format

For each of the T test cases, print a single line consisting N−1 space separated integers denoting the shortest distance of N−1 nodes from starting position S.

For unreachable nodes, print −1.

Sample Input

1
4 4
1 2 24
1 4 20
3 1 3
4 3 12
1

Sample Output

24 3 15

*/