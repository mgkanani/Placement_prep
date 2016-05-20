import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Practice {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N,L;
        N = sc.nextInt();
        L = sc.nextInt();
        UnionFind uf = new UnionFind(N);
        int i=0,u,v;
        for(i=0;i<L;i++){
            u = sc.nextInt();
            v = sc.nextInt();
            uf.union(u,v);
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(i=0;i<N;i++){
            u = uf.find(i);
            v=0;
            if(map.containsKey(u)){
                v = map.get(u);
            }
            map.put(u,v+1);
        }
        Object arr[] = map.values().toArray();
        long val=0;
        for(i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                val += (Integer)arr[i]*(Integer)arr[j];
            }
        }
        System.out.println(val);
    }
}

class UnionFind{
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

    public String toString() {
    	return "<UnionFind\n_p " + Arrays.toString(_p) + "\ncnt "+cnt+"\n>";
	}
}


/*
UnionFind Application.


Journey to the Moon



Problem Statement

The member states of the UN are planning to send 2 people to the Moon. But there is a problem. In line with their principles of global unity, they want to pair astronauts of 2 different countries.

There are N trained astronauts numbered from 0 to N-1. But those in charge of the mission did not receive information about the citizenship of each astronaut. The only information they have is that some particular pairs of astronauts belong to the same country.

Your task is to compute in how many ways they can pick a pair of astronauts belonging to different countries. Assume that you are provided enough pairs to let you identify the groups of astronauts even though you might not know their country directly. For instance, if 1,2,3 are astronauts from the same country; it is sufficient to mention that (1,2) and (2,3) are pairs of astronauts from the same country without providing information about a third pair (1,3).

Input Format

The first line contains two integers, N and L, separated by a single space. L lines follow. Each line contains 2 integers separated by a single space A and B such that

0 ≤ A, B ≤ N-1

and A and B are astronauts from the same country. Where 1<=N<=100000, 1<=L<=10000

Output Format

An integer that denotes the number of permissible ways to choose a pair of astronauts.

Sample Input

4 2

0 1

2 3

Sample Output

4

Explanation

Persons numbered 0 and 1 belong to same country, and those numbered 2 and 3 belong to same country. So the UN can choose one person out of 0 & 1 and another person out of 2 & 3. So number of ways of choosing a pair of astronauts is 4.

*/