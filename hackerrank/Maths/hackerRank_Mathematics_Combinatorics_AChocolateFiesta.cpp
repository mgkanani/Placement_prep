#include <vector>
#include <iostream>
using namespace std;

long long MOD = 1000000007;

int main() {
    int n;
    cin >> n;
    vector<int> v(n);
    int even = 0, odd = 0;
    for(int i=0; i<n; ++i) {
        cin >> v[i];
        if(v[i]%2==0) even++;
        else odd++;
    }
    long long possEven = 1;
    for(int j=1; j<=even; ++j) {
        possEven = (possEven*2)%MOD;
    }
    long long possOdd = 1;
    for(int j=1; j<odd; ++j) {
        possOdd = (possOdd*2)%MOD;
    }
    long long ans = (possEven*possOdd)%MOD-1;
    cout << ans << endl;
    return 0;
}