#include <iostream>
#include <map>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

void anagram(vector<string>& arr, int n) {
	set<string> anagrps;
	sort(arr.begin(), arr.end());
	map<string, string> m;
	for(int i=0; i<n; i++) {
		string str = arr[i];
		sort(str.begin(), str.end());
		if(m.find(str) == m.end()) m[str] = arr[i]; 
		else {
			if(m[str] != "") {
				anagrps.insert(m[str]);
				m[str] = "";
			}
			anagrps.insert(arr[i]);
		}
	}
	cout << anagrps.size() << " " << *anagrps.begin() << endl;		
}

int main() {
	int n;
	cin >> n;;
	vector<string> v(n);
	for(int i=0; i<n; i++) cin >> v[i];
	anagram(v, n);
	return 0;
}










// #include <iostream>
// #include <vector>
// #include <map>
// #include <set>
// #include <string>
// #include <algorithm>
// using namespace std;
// void anagram(vector<string>&, int);
// int main() {
// 	int n; cin >> n;
// 	vector<string> v(n);
// 	for(int i=0; i<n; ++i) cin >> v[i];
// 	anagram(v, n);
// 	return 0;
// }

// void anagram(vector<string>& v, int n) {
// 	map<string, set<string>> m;
// 	string temp;
// 	set<string> ss;
// 	for(int i=0; i<n; ++i) {
// 		temp = v[i];
// 		sort(v[i].begin(), v[i].end());
// 		if(m.find(v[i])!=m.end()) m[v[i]].insert(temp);
// 		else { ss.insert(temp); m.insert(make_pair(v[i], ss)); }
// 		ss.clear();
// 	}
// 	map<string, set<string>>::iterator it;
// 	int total = 0;
// 	string result;
// 	set<string> st;
// 	set<string>::iterator itt;
// 	bool flag = false;
// 	for(it=m.begin(); it!=m.end(); ++it) {
// 		if(!flag) {
// 			st = it->second;
// 			if(!flag) { result = *st.begin(); flag = true; }
// 			else break;
// 			flag = true;
// 		}
// 		if((it->second).size()>1) total += (it->second).size();
// 	}
// 	cout << total << " " << result << endl;
// }