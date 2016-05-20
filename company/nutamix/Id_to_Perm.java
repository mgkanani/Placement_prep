import java.util.*;
public class Id_to_Perm{
	public static void PR(Object obj){ System.out.print(obj); }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int arr[] = process(s);
		for(int i :arr)
			PR(i+"\t");
	}
	public static int[] process(String s){
		int len = s.length();
		int arr[] = new int[len+1];
		// if(s.length()==0){
		// 	return null;
		// }
		int i=len-1;
		char c;
		int n = len+1;
		int temp =n;
		int ind=0;
		while(n>0 && i>=0){
			temp = n;
			while(i>=0 && s.charAt(i)=='d'){
				i--;
				n--;
			}
			if(temp!=n)
				i++;
			ind=1;
			while(temp!=n){
				arr[i+ind] = temp;
				ind++;
				temp--;
			}
			arr[i] = temp;
			i--;
			n--;
		}
		arr[0] = n;
		return arr;
	}
}