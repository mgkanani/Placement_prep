/*

Merging Communities



Problem Statement

People connect with each other in a social network. A connection between Person I and Person J is represented as M I J. When two persons belonging to different communities connect, the net effect is the merger of both communities which I and J belongs to.

At the beginning, there are N people representing N communities. Suppose person 1 and 2 connected and later 2 and 3 connected, then 1,2, and 3 will belong to the same community.

There are two type of queries:

    M I J⟹ communities containing person I and J merged (if they belong to different communities).

    Q I⟹ print the size of the community to which person I belongs.

Input Format

The first line of input will contain integers N and Q, i.e. the number of people and the number of queries.
The next Q lines will contain the queries.

Constraints :
1≤N≤105
1≤Q≤2×105

Output Format

The output of the queries.

Sample Input

3 6
Q 1
M 1 2
Q 2
M 2 3
Q 3
Q 2

Sample Output

1
2
3
3

Explanation

Initial size of each of the community is 1.

*/
import java.util.*;

public class MergeSet {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n,q,id,id1,id2;
        n=sc.nextInt();
        q = sc.nextInt();
        StringBuilder br = new StringBuilder(q*9);
        //sc.next();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>(n,1);
        for(int i=0;i<q;i++){
            String s = sc.next();
            //System.out.println(s);
            if(s.equals("Q")){
                id = sc.nextInt();
                //sc.next();
                br.append(search(map,id)+"\n");
            }else{
                id1 = sc.nextInt();
                id2 = sc.nextInt();
                //sc.next();
                merge(map,id1,id2);
            }
        }
        System.out.print(br);
    }
    public static int search(HashMap<Integer,HashSet<Integer>> map, int id){
        if(map.containsKey(id)){
            return map.get(id).size();
        }
        return 1;
    }
    public static void merge(HashMap<Integer,HashSet<Integer>> map, int id1, int id2){
        if(map.containsKey(id1)){//id1 is within a set.
            if(map.containsKey(id2)){
                int j=0;
                HashSet<Integer> set1,set2,t1;
                set1=map.get(id1);
                set2=map.get(id2);
                if(set1.size()<set2.size()){
                    t1=set2;
                    set2 = set1;
                    set1=t1;
                }
                Iterator<Integer> i = set2.iterator();
                while(i.hasNext()){
                        j = i.next();
                        set1.add(j);
                        map.put(j,set1);
                }
            }else{
                map.get(id1).add(id2);
                map.put((Integer)id2,map.get(id1));
            }
        }else if(map.containsKey(id2)){ //id1 is not in any set.
            map.get(id2).add(id1);
            map.put((Integer)id1,map.get(id2));
        }else{
            HashSet<Integer> set = new HashSet<Integer>(2);
            set.add(id1);
            set.add(id2);
            map.put((Integer)id1,set);
            map.put((Integer)id2,set);
        }
    }
}