import java.util.*;
public class BadHorse{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int T,M;
		T=sc.nextInt();
		StringBuilder br;// = new StringBuilder(T*15);
		int i,j;
		String s1,s2;
		HashMap<String,Boolean> m1,m2;
		for(i=0;i<T;i++){
			br = new StringBuilder(15);
			m1= new HashMap<String,Boolean>();
			m2= new HashMap<String,Boolean>();
			M=sc.nextInt();
			boolean flag=true;
			for(j=0;j<M;j++){
				s1=sc.next();
				s2=sc.nextLine();
				if(m1.containsKey(s1)){
					if(m1.containsKey(s2)){
						if(flag)
							br.append("Case #"+(i+1)+": No\n");
						flag=false;
						//continue;
					}else{
						m2.put(s2,true);
					}
				}else if(m1.containsKey(s2)){
					m2.put(s1,true);
				}else if(m2.containsKey(s1)){
					if(m1.containsKey(s2)){
						if(flag)
							br.append("Case #"+(i+1)+": No\n");
						flag=false;
					}else{
						m1.put(s2,true);
					}
				}else if(m2.containsKey(s2)){
					m1.put(s1,true);
				}else{
					m1.put(s1,true);
					m2.put(s2,true);
				}
			}
			if(flag){
				br.append("Case #"+(i+1)+": Yes\n");
			}
			System.out.print(br);
			br=null;
		}
		//System.out.print(br);
	}
}
