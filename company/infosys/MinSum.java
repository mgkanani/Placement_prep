import java.util.*;
public class MinSum{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//int T=s
		String str = null;
		int[] a,b;
		//StringBuilder br = new StringBuilder();
		str = sc.nextLine();
		System.out.println(process(str));
	}
	public static int process(String s){
		String strs[] = s.split("#");
		int a[],b[];
		String temp[] = strs[0].split(" ");
		a = new int[temp.length];
		b = new int[temp.length];
		int i=0;
		for(String tmp: temp){
			a[i++]=Integer.parseInt(tmp);
		}
		i=0;
		for(String tmp: strs[1].split(" ")){
			b[i++]=Integer.parseInt(tmp);
		}
		return findMin(a,b);
	}
	public static int findMin(int[] a, int[] b){
		int min=a[0]*b[0];
		int temp;
		for(int i=1;i<a.length;i++){
			temp = a[i]*b[i];
			if(temp+min<min){
				min = temp+min;
			}
		}
		return min;
	}
}