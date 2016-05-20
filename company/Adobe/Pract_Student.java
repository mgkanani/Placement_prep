import java.util.*;
public class Pract_Student{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int itr = 0;
		while(itr<T){
			int N=sc.nextInt();
			int i=0;
			int pairs=0,sub_cnt=0;
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			BitSet bitmap[] = new BitSet[N];
			for(i=0;i<N;i++){
				int k = sc.nextInt();
				bitmap[i]= new BitSet();
				for(int j=0;j<k;j++){
					String sub = sc.next();
					if(!map.containsKey(sub)){
						map.put(sub,sub_cnt);
						bitmap[i].set(sub_cnt);
						sub_cnt++;
					}else{
						int sub_id = map.get(sub);
						bitmap[i].set(sub_id);
					}
				}
			}
			BitSet curr = null;
			for(i=0;i<bitmap.length-1;i++){
				for(int j=i+1;j<bitmap.length;j++){
					curr = (BitSet)bitmap[i].clone();
					curr.and(bitmap[j]);
					if(!curr.isEmpty()){
						pairs++;
					}
				}
			}
			System.out.println(pairs);
			itr++;
		}
	}
}