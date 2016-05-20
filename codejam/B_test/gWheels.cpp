#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int t;
	cin >> t;
	int ii = 1;
	while(t--) {
		cout << "Case #" << ii << ":" << endl;
		int np, ne, nt;
		cin >> np >> ne >> nt;
		int npa[np]; int nea[ne]; int nta[nt];
		for(int i=0; i<np; ++i) cin >> npa[i];
		for(int i=0; i<ne; ++i) cin >> nea[i];
		for(int i=0; i<nt; ++i) cin >> nta[i];
		sort(npa,npa+np);
		sort(nea,nea+ne);
		sort(nta,nta+nt);
		int nq; cin >> nq;
		while(nq--) {
			bool flag = false;
			double p, q;
			cin >> p >> q;	
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
								if(abs((x*z)/(y*za)-(p/q))<=0.000001) {
									cout << "Yes" << endl;
									flag = true;
									break;
								}
							}
						}
						if(flag) break;
					}
					if(flag) break;
				}
				if(flag) break;
			}
			if(!flag) cout << "No" << endl;
		}
		ii++;
	}
	return 0;
}