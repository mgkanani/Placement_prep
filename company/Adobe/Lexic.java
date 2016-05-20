import java.util.*;
public class Lexic{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =  sc.next();
		String pstr =  sc.next();
		char []p= pstr.toCharArray();
		int cnt[] = new int[26];
		StringBuilder br = new StringBuilder(str.length());
		for(char c: str.toCharArray()){
			cnt[c-'a']++;
		}
		for(int i=0;i<26;i++){
			//if(p)
			int temp = cnt[p[i]-'a'];
			while(temp>0){
				br.append(p[i]);
				temp--;
			}
		}
		System.out.println(br);
	}
}