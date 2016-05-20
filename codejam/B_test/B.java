import java.util.*;
public class B{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int ii = 1;
		while(t-- > 0) {
			System.out.println("Case #"+ii+":");
			int np, ne, nt;
			np = sc.nextInt();
			ne = sc.nextInt();
			nt = sc.nextInt();
			int npa[] = new int[np];
			int nea[] = new int[ne];
			int nta[] = new int[nt];
			for(int i=0; i<np; ++i){
				npa[i] = sc.nextInt();
			}
			for(int i=0; i<ne; ++i){
				nta[i] = sc.nextInt();
			}
			for(int i=0; i<nt; ++i){
				nta[i] = sc.nextInt();
			}
			Arrays.sort(npa);
			Arrays.sort(nea);
			Arrays.sort(nta);
			int nq;
			nq = sc.nextInt();
			while(nq-- > 0) {
				boolean flag = false;
				double p, q;
				p = sc.nextInt();
				q = sc.nextInt();
				for(int i=0; i<np; ++i) {
					for(int j=0; j<ne; ++j) {
						double x = (double)npa[i];
						double y = (double)nea[j];
						double rpe = x/y;
						for(int k=0; k<ne; ++k) {
							for(int l=0; l<nt; ++l) {
								double z;
								if(j!=k) {
									z = nea[k];
									double za = nta[l];
									if(Math.abs((x*z)/(y*za)-(p/q))<=0.000001) {
										System.out.println("Yes");
										flag = true;
										break;
									}
								}
							}
						if(flag)
							break;
						}
						if(flag)
							break;
					}
					if(flag)
						break;
				}
				if(!flag)
					System.out.println("No");
			}
			ii++;
		}
	}
}
