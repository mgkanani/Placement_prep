#include <bits/stdc++.h>

using namespace std;
int counts = 0;
void part(int *arr, int s, int e){ //nlogn
    int part_i = -1, mini = e - s + 1;
    int m1 = (s+e)/2, m2 = (s+e)/2 + 1;
    for(int i = s; i <= e; i++){
        int temp = -1;
        if(arr[i]){
            temp = abs(m1 - i);
            if((s-e)%2) temp = min(temp, abs(m2-i));
            if(temp < mini) part_i = i, mini = temp;
        }
    }
    if(part_i == -1) return;
    else counts += e-s;
    if(s != part_i) part(arr, s, part_i - 1);
    if(e != part_i) part(arr, part_i + 1, e);
}

int main(){
    int n, m; cin >> n >> m;
    int *arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = 0;
    for (int i = 0; i < m; i++) {
        int a; cin >> a; a--;
        arr[a] = 1;
    }
    part(arr, 0, n-1);
    cout << counts << endl;
    return 0;
}