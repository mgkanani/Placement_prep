import java.util.*;
public class Hungry{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s[] = sc.nextLine().split("#");
		int val = Integer.parseInt(s[0]);
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int moves=0,i=0;
		String ele[]=null;
		if(s.length>1){
			ele = s[1].split(",");
			moves=ele.length;
		}
		if(val>0){
			int arr[] = new int[ele.length];
			for(i=0;i<ele.length;i++){
				arr[i] = Integer.parseInt(ele[i]);
			}
			Arrays.sort(arr);
			moves = find(val,arr,0);
		}
		System.out.println(moves);
	}

	public static int find(int val, int[] arr, int index){
		if(index>=arr.length)
			return 0;
		if(val>arr[index])
			return find((val+arr[index]),arr,index+1);
		return 1 + Math.min(find(2*val-1,arr,index), find(val,arr,index+1));
	}
}