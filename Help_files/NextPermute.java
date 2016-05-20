import java.util.*;

public class NextPermute{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char arr[] = str.toCharArray();
		next(arr,0,arr.length);
		System.out.println((3+1)/3*6);
		for(int i=1;i<50;i++){
			System.out.println(i+"\t"+isLucky(i,2));
		}
	}
	public static void next(char[] arr, int l, int r){
		if(l==r){
			System.out.println(new String(arr));
			return;
		}
		else
			for(int i=l;i<r;i++){
				swap(arr,l,i);
				next(arr,l+1,r);
				swap(arr,l,i);
			}
	}
	public static void swap(char[] arr, int i , int j){
		char c=arr[i];
		arr[i]=arr[j];
		arr[j]=c;
	}

	public static boolean isLucky(int n, int k){
		if(n==k || n%k==0)
			return false;
		if(n<k)
			return true;
		else 
			return isLucky(n-(n/k),k+1);
	}
	/*
		Babylonian method for square root
	*/
	public static int squareRoot(int n){
		int x = n;
		int y = 1;
		while(x > y){
		    x = (x + y)/2;
		    y = n/x;
		}
		return x;
	}
}

/*
next Permutation in order.
*/
