/*
There are N students, each having a list of favourite subjects.
You have to find total no. of pairs of students that can help each other.
Two students can help each other if they have a common subject.

Input Format:
First line contains the no. of students, N.
Next N lines each has a number of the favourite subjects followed by the list of subjects.

Ex.
3
3 dfs bfs graph
1 flow 
2 flow graph	

Output:
2
N, Total no. of subjects (K) <=1000
Brute Force was not acceptable


BitSet example 
*/
import java.util.*;

class StudentsAndSubjects {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		Map<String, Integer> indexMap = new HashMap<String, Integer>();
		BitSet[] bitmap = new BitSet[t];

		int subCount = 0;
		for (int i = 0;i < t ; i++) {
			int n = s.nextInt();
			bitmap[i] = new BitSet();
			for (int j = 0; j  <n; j++) {
				String str = s.next();
				if (!indexMap.containsKey(str)) {
					indexMap.put(str, subCount);
					bitmap[i].set(subCount);
					subCount++;
				}else{
					int sub_bit = indexMap.get(str);
					//System.out.println("sub_bit:- "+sub_bit);
					bitmap[i].set(sub_bit);
				}
			}
		}

		int count  = 0;
		BitSet curr = null;
		for (int i = 0; i < bitmap.length - 1; i++) {
			curr = bitmap[i];
			for (int j = i + 1; j < bitmap.length; j++) {
				curr = (BitSet)bitmap[i].clone();
				curr.and(bitmap[j]);
				if ( !curr.isEmpty() ) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}