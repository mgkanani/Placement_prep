// C++ program to find n'th number in a number system with only 3 and 4
#include <iostream>
using namespace std;

// Function to find n'th number in a number system with only 3 and 4
void find(int n)
{
	// An array of strings to store first n numbers. arr[i] stores i'th number
	string arr[n+1];
	arr[0] = ""; // arr[0] stores the empty string (String with 0 digits)

	// size indicates number of current elements in arr[]. m indicates
	// number of elements added to arr[] in previous iteration.
	int size = 1, m = 1;

	// Every iteration of following loop generates and adds 2*m numbers to
	// arr[] using the m numbers generated in previous iteration.
	while (size <= n)
	{
		// Consider all numbers added in previous iteration, add a prefix
		// "3" to them and add new numbers to arr[]
		for (int i=0; i<m && (size+i)<=n; i++)
			arr[size + i] = "3" + arr[size - m + i];

		// Add prefix "4" to numbers of previous iteration and add new
		// numbers to arr[]
		for (int i=0; i<m && (size + m + i)<=n; i++)
			arr[size + m + i] = "4" + arr[size - m + i];

		// Update no. of elements added in previous iteration
		m = m<<1; // Or m = m*2;

		// Update size
		size = size + m;
	}
	cout << arr[n] << endl;
}

// Driver program to test above functions
int main()
{
	//for (int i = 1; i < 16; i++)
	int n;
	cin>>n;
		find(n);
	return 0;
}

