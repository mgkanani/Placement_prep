// Copied from internet
// https://www.hackerrank.com/contests/womenscup/challenges/coding-camp-for-girls
#include <iostream>
#include <vector>
#include <set>
using namespace std;

bool visited[10000005];
int parent[10000005];

vector<int> circle;
set<int> strong_pairs;

int circle_parent(int circle) {
    return (circle == parent[circle]) ? circle : circle_parent(parent[circle]);
}

int main()
{
    int n, m;
    cin >> n >> m;
    for(int i=1; i<=n+1; i++) visited[i] = parent[i] = i;
    while(m--) {
        int l, r;
        cin >> l >> r;
        int current_parent = circle_parent(l);
        while (r >= current_parent) {
            circle.push_back(current_parent);
            if (current_parent == l) {
                if (r >= (current_parent+1) && !visited[current_parent+1]) {
                    strong_pairs.insert(current_parent);
                }
            } else if (current_parent == r) {
                if (current_parent>=(l+1) && !visited[current_parent-1]) {
                    strong_pairs.insert(current_parent-1);
                }
            } else {
                if (!visited[current_parent-1]) {
                    strong_pairs.insert(current_parent-1);
                }
                if (!visited[current_parent+1]) {
                    strong_pairs.insert(current_parent);
                }
            }
            current_parent = (parent[current_parent] = circle_parent(current_parent+1));
        }
        for (int i : circle) {
            visited[i] = false;
            circle.pop_back();
        }
    }
    cout << strong_pairs.size() << endl;
    for (int i : strong_pairs) cout << i << " " << (i + 1) << endl;
    return 0;
}