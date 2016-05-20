#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// In place of algorithmic functions, we can use 2 random numbers at one go and
// can swap to elements at those indexes.
// Avg case complexity : O(n.n!)
// Worst case : May never get sorted

int main() {
	int n;
	cin >> n;
	vector<int> array(n);
	for(int i=0; i<n; i++) cin >> array[i];
	while(!std::is_sorted(array.begin(), array.end())) {
		std::random_shuffle(array.begin(), array.end());
	}
	for(int i=0; i<n; i++) cout << array[i] << " ";
	cout << endl;
	return 0;
}