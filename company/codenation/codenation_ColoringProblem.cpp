#include <iostream>
#include <vector>
using namespace std;

void printSolution(vector<int>& color, int v)
{
    for (int i = 0; i < v; i++) cout << color[i] << " ";
    cout << endl;
}

bool isSafe(int vertex, vector<vector<bool>>& graph, vector<int>& color, int c, int v) 
{
    for (int i = 0; i < v; i++)
        if (graph[vertex][i] && c == color[i]) return false;
    return true;
}
 
bool graphColoringUtil(vector<vector<bool>>& graph, int m, vector<int>& color, int vertex, int v)
{
    if (vertex == v) return true;
    for (int c = 1; c <= m; c++) {
        if (isSafe(vertex, graph, color, c, v)) {
           color[vertex] = c;
           if (graphColoringUtil (graph, m, color, vertex+1, v) == true) return true;
           color[vertex] = 0;
        }
    }
    return false;
}
 
bool graphColoring(vector<vector<bool>>& graph, int m, int v)
{
    vector<int> color(v);
    if (graphColoringUtil(graph, m, color, 0, v) == false) {
        cout << "No solution" << endl;
        return false;
    }
    printSolution(color, v);
    return true;
}
 
int main()
{
    int v, e, i, j, m;
    cin >> v >> e;
    vector<vector<bool>> graph(v, vector<bool>(v));
    for(int ii=0; ii<e; ++ii) {
        cin >> i >> j;
        graph[i][j] = graph[j][i] = 1;
    }
    cin >> m;
    graphColoring(graph, m, v);
    return 0;
}