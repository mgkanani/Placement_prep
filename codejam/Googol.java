import java.util.*;
public class Googol{
	public static void main(String arg[]){
		int i=1,j;
		i = i<<60;
		StringBuilder br = new StringBuilder(i);
		StringBuilder br1;//= new StringBuilder(i/2);;
		br.append("0");
		//System.out.println(br);
		for(i=2;i<60;i++){
			br1 = new StringBuilder(br.length());
			for(j=0;j<br.length();j++)
				br1.append(br.charAt(j)=='0'?'1':'0');
			br.append("0"+br1.reverse());
		}
		//System.out.println(br);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long K;
		for(i=1;i<=T;i++){
			K=sc.nextLong();
			//System.out.println("Case #"+i+": "+br.charAt(K-1));
		}
	}
}
