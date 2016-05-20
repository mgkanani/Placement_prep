import java.util.*;
public class RangeMin{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt=0,t1=n;
		while(t1>0){t1>>=1;cnt++;}
		int arr[][] = new int[n][cnt];
		int i=0;
		for(i=0;i<n;i++){
			arr[i][0]=sc.nextInt();
		}
		t1=1;
		int j=1;
		int end=n;
		while(j<cnt){
			if(end<=t1){
				
			}else{
				end-=t1;
				for(i=0;i<end;i++){
					arr[i][j] = Math.min(arr[i][j-1],arr[i+t1][j-1]);
					System.out.print(arr[i][j]+" ");
				}
			}
			System.out.println();
			t1<<=1;
			j++;
		}
	}
}