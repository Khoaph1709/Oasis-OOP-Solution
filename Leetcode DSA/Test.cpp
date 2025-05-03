#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Graph {
    int V;
    vector<vector<int>> adj;

    Graph(int V) {
        this->V = V;
        adj.resize(V);
    }

    void addEdge(int u, int v) {
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    void DFS(int v, vector<bool>& visited) {
        visited[v] = true;
        cout << v << " ";

        for (int u : adj[v]) {
            if (!visited[u]) {
                DFS(u, visited);
            }
        }
    }

    void DFS(int v) {
        vector<bool> visited(V, false);
        DFS(v, visited);
    }

    void KruskalMST();
};

void Graph::KruskalMST() {
    vector<pair<int, pair<int, int>>> edges;
    for (int v = 0; v < V; v++) {
        for (int u : adj[v]) {
            edges.push_back(make_pair(1, make_pair(v, u)));
        }
    }

    sort(edges.begin(), edges.end());
    vector<int> parent(V);
    for (int i = 0; i < V; i++) {
        parent[i] = i;
    }

    int mst_weight = 0;
    for (auto edge : edges) {
        int weight = edge.first;
        int u = edge.second.first;
        int v = edge.second.second;
        int parent_u = parent[u];
        int parent_v = parent[v];

        if (parent_u != parent_v) {
            mst_weight += weight;
            cout << u << " - " << v << endl;

            for (int i = 0; i < V; i++) {
                if (parent[i] == parent_v) {
                    parent[i] = parent_u;
                }

            }

        }

    }
    cout << "Weight of MST: " << mst_weight << endl;
}

int squareRoot(int x) {
    
}

int main() {
    int x = 15;
    int root = squareRoot(x);
    cout << "Square root of " << x << " is " << root << endl;

    return 0;
}