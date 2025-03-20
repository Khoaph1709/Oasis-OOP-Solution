// Graph Implementation Template
// Based on concepts from 07_graphs.pdf

#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <stdexcept>
#include <functional>
#include <algorithm>

//-------------------- GRAPH BASE CLASS --------------------
class Graph
{
protected:
    int numVertices;
    bool directed;

public:
    Graph(int vertices, bool isDirected = false) : numVertices(vertices), directed(isDirected) {}

    virtual ~Graph() {}

    bool isDirected() const
    {
        return directed;
    }

    int getNumVertices() const
    {
        return numVertices;
    }

    virtual void addEdge(int source, int destination) = 0;
    virtual bool hasEdge(int source, int destination) const = 0;
    virtual std::vector<int> getNeighbors(int vertex) const = 0;
    virtual void printGraph() const = 0;
};

//-------------------- ADJACENCY MATRIX IMPLEMENTATION --------------------
class AdjacencyMatrixGraph : public Graph
{
private:
    std::vector<std::vector<bool>> matrix;

public:
    AdjacencyMatrixGraph(int vertices, bool isDirected = false) : Graph(vertices, isDirected)
    {
        matrix.resize(numVertices, std::vector<bool>(numVertices, false));
    }

    void addEdge(int source, int destination) override
    {
        if (source < 0 || source >= numVertices || destination < 0 || destination >= numVertices) {
            throw std::out_of_range("Vertex index out of bounds");
        }
        
        matrix[source][destination] = true;
        
        if (!directed) {
            matrix[destination][source] = true;
        }
    }

    bool hasEdge(int source, int destination) const override
    {
        if (source < 0 || source >= numVertices || destination < 0 || destination >= numVertices) {
            return false;
        }
        
        return matrix[source][destination];
    }

    std::vector<int> getNeighbors(int vertex) const override
    {
        if (vertex < 0 || vertex >= numVertices) {
            return {};
        }
        
        std::vector<int> neighbors;
        for (int i = 0; i < numVertices; i++) {
            if (matrix[vertex][i]) {
                neighbors.push_back(i);
            }
        }
        return neighbors;
    }

    void printGraph() const override
    {
        std::cout << "  ";
        for (int i = 0; i < numVertices; i++) {
            std::cout << i << " ";
        }
        std::cout << std::endl;
        
        for (int i = 0; i < numVertices; i++) {
            std::cout << i << " ";
            for (int j = 0; j < numVertices; j++) {
                std::cout << (matrix[i][j] ? "1 " : "0 ");
            }
            std::cout << std::endl;
        }
    }
};

//-------------------- ADJACENCY LIST IMPLEMENTATION --------------------
class AdjacencyListGraph : public Graph
{
private:
    std::vector<std::vector<int>> adjacencyList;

public:
    AdjacencyListGraph(int vertices, bool isDirected = false) : Graph(vertices, isDirected)
    {
        adjacencyList.resize(numVertices);
    }

    void addEdge(int source, int destination) override
    {
        if (source < 0 || source >= numVertices || destination < 0 || destination >= numVertices) {
            throw std::out_of_range("Vertex index out of bounds");
        }
        
        adjacencyList[source].push_back(destination);
        
        if (!directed) {
            adjacencyList[destination].push_back(source);
        }
    }

    bool hasEdge(int source, int destination) const override
    {
        if (source < 0 || source >= numVertices || destination < 0 || destination >= numVertices) {
            return false;
        }
        
        for (int neighbor : adjacencyList[source]) {
            if (neighbor == destination) {
                return true;
            }
        }
        
        return false;
    }

    std::vector<int> getNeighbors(int vertex) const override
    {
        if (vertex < 0 || vertex >= numVertices) {
            return {};
        }
        
        return adjacencyList[vertex];
    }

    void printGraph() const override
    {
        for (int i = 0; i < numVertices; i++) {
            std::cout << i;
            for (int neighbor : adjacencyList[i]) {
                std::cout << " -> " << neighbor;
            }
            std::cout << std::endl;
        }
    }
};

//-------------------- GRAPH TRAVERSAL ALGORITHMS --------------------
class GraphAlgorithms
{
public:
    // Depth-First Search (DFS) implementation
    static void DFS(const Graph &graph, int startVertex, std::vector<bool> &visited)
    {
        visited[startVertex] = true;
        std::cout << "Visited vertex: " << startVertex << std::endl;

        std::vector<int> neighbors = graph.getNeighbors(startVertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                DFS(graph, neighbor, visited);
            }
        }
    }

    // Iterative DFS using a stack
    static void DFSIterative(const Graph &graph, int startVertex)
    {
        int numVertices = graph.getNumVertices();
        std::vector<bool> visited(numVertices, false);
        std::stack<int> stack;
        
        stack.push(startVertex);
        
        while (!stack.empty()) {
            int currentVertex = stack.top();
            stack.pop();
            
            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                std::cout << "Visited vertex: " << currentVertex << std::endl;
                
                std::vector<int> neighbors = graph.getNeighbors(currentVertex);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    if (!visited[neighbors[i]]) {
                        stack.push(neighbors[i]);
                    }
                }
            }
        }
    }

    // Breadth-First Search (BFS) implementation
    static void BFS(const Graph &graph, int startVertex)
    {
        int numVertices = graph.getNumVertices();
        std::vector<bool> visited(numVertices, false);
        std::queue<int> queue;
        
        visited[startVertex] = true;
        queue.push(startVertex);
        
        while (!queue.empty()) {
            int currentVertex = queue.front();
            queue.pop();
            
            std::cout << "Visited vertex: " << currentVertex << std::endl;
            
            std::vector<int> neighbors = graph.getNeighbors(currentVertex);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.push(neighbor);
                }
            }
        }
    }

    // Find connected components in an undirected graph
    static int findConnectedComponents(const Graph &graph)
    {
        int numVertices = graph.getNumVertices();
        std::vector<bool> visited(numVertices, false);
        int componentCount = 0;
        
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                componentCount++;
                DFS(graph, i, visited);
            }
        }
        
        return componentCount;
    }

    // Check if a graph is bipartite
    static bool isBipartite(const Graph &graph)
    {
        int numVertices = graph.getNumVertices();
        std::vector<int> colors(numVertices, -1); // -1: no color, 0: first color, 1: second color
        
        for (int startVertex = 0; startVertex < numVertices; startVertex++) {
            if (colors[startVertex] == -1) {
                std::queue<int> queue;
                colors[startVertex] = 0;
                queue.push(startVertex);
                
                while (!queue.empty()) {
                    int currentVertex = queue.front();
                    queue.pop();
                    
                    std::vector<int> neighbors = graph.getNeighbors(currentVertex);
                    for (int neighbor : neighbors) {
                        if (colors[neighbor] == -1) {
                            colors[neighbor] = 1 - colors[currentVertex];
                            queue.push(neighbor);
                        }
                        else if (colors[neighbor] == colors[currentVertex]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }

    // Find shortest path between two vertices (unweighted graph)
    static std::vector<int> findShortestPath(const Graph &graph, int startVertex, int endVertex)
    {
        int numVertices = graph.getNumVertices();
        std::vector<bool> visited(numVertices, false);
        std::vector<int> parent(numVertices, -1);
        std::queue<int> queue;
        
        visited[startVertex] = true;
        queue.push(startVertex);
        
        bool found = false;
        
        while (!queue.empty() && !found) {
            int currentVertex = queue.front();
            queue.pop();
            
            if (currentVertex == endVertex) {
                found = true;
                break;
            }
            
            std::vector<int> neighbors = graph.getNeighbors(currentVertex);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = currentVertex;
                    queue.push(neighbor);
                }
            }
        }
        
        if (!found) {
            return {};
        }
        
        std::vector<int> path;
        for (int v = endVertex; v != -1; v = parent[v]) {
            path.push_back(v);
        }
        
        std::reverse(path.begin(), path.end());
        return path;
    }

    // Topological sort (for directed acyclic graphs)
    static std::vector<int> topologicalSort(const Graph &graph)
    {
        int numVertices = graph.getNumVertices();
        std::vector<bool> visited(numVertices, false);
        std::vector<int> result;
        
        std::function<void(int)> topologicalDFS = [&](int vertex) {
            visited[vertex] = true;
            
            std::vector<int> neighbors = graph.getNeighbors(vertex);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    topologicalDFS(neighbor);
                }
            }
            
            result.insert(result.begin(), vertex);
        };
        
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                topologicalDFS(i);
            }
        }
        
        return result;
    }

    // Helper function for first DFS pass in Kosaraju's algorithm
    static void kosarajuFirstDFS(const Graph &graph, int vertex, std::vector<bool> &visited,
                                std::stack<int> &finishOrder)
    {
        visited[vertex] = true;
        
        std::vector<int> neighbors = graph.getNeighbors(vertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                kosarajuFirstDFS(graph, neighbor, visited, finishOrder);
            }
        }
        
        finishOrder.push(vertex);
    }

    // Helper function for second DFS pass in Kosaraju's algorithm
    static void kosarajuSecondDFS(const Graph &graph, int vertex, std::vector<bool> &visited,
                                std::vector<int> &component)
    {
        visited[vertex] = true;
        component.push_back(vertex);
        
        std::vector<int> neighbors = graph.getNeighbors(vertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                kosarajuSecondDFS(graph, neighbor, visited, component);
            }
        }
    }

    // Find strongly connected components using Kosaraju's algorithm
    static std::vector<std::vector<int>> findStronglyConnectedComponents(const Graph &graph)
    {
        int numVertices = graph.getNumVertices();
        std::vector<std::vector<int>> sccList;
        
        if (!graph.isDirected()) {
            std::cout << "Error: Strongly connected components only defined for directed graphs.\n";
            return sccList;
        }
        
        std::vector<bool> visited(numVertices, false);
        std::stack<int> finishOrder;
        
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                kosarajuFirstDFS(graph, i, visited, finishOrder);
            }
        }
        
        Graph* transposeGraph = new AdjacencyListGraph(numVertices, true);
        for (int i = 0; i < numVertices; i++) {
            std::vector<int> neighbors = graph.getNeighbors(i);
            for (int neighbor : neighbors) {
                transposeGraph->addEdge(neighbor, i);
            }
        }
        
        std::fill(visited.begin(), visited.end(), false);
        
        while (!finishOrder.empty()) {
            int vertex = finishOrder.top();
            finishOrder.pop();
            
            if (!visited[vertex]) {
                std::vector<int> component;
                kosarajuSecondDFS(*transposeGraph, vertex, visited, component);
                sccList.push_back(component);
            }
        }
        
        delete transposeGraph;
        
        return sccList;
    }
};

//-------------------- TESTING FUNCTION --------------------
void testGraphImplementations()
{
    // Test Adjacency Matrix (Undirected)
    std::cout << "======= Testing Undirected Adjacency Matrix Graph =======\n";
    AdjacencyMatrixGraph matrixGraph(5);

    // Add edges
    matrixGraph.addEdge(0, 1);
    matrixGraph.addEdge(0, 4);
    matrixGraph.addEdge(1, 2);
    matrixGraph.addEdge(1, 3);
    matrixGraph.addEdge(1, 4);
    matrixGraph.addEdge(2, 3);
    matrixGraph.addEdge(3, 4);

    // Print the graph
    std::cout << "Adjacency Matrix:\n";
    matrixGraph.printGraph();

    // Test edge existence
    std::cout << "Edge (0,1): " << (matrixGraph.hasEdge(0, 1) ? "exists" : "doesn't exist") << std::endl;
    std::cout << "Edge (2,4): " << (matrixGraph.hasEdge(2, 4) ? "exists" : "doesn't exist") << std::endl;

    // Test neighbors
    std::cout << "Neighbors of vertex 1: ";
    std::vector<int> neighbors = matrixGraph.getNeighbors(1);
    for (int neighbor : neighbors)
    {
        std::cout << neighbor << " ";
    }
    std::cout << std::endl;

    // Test Adjacency List (Directed)
    std::cout << "\n======= Testing Directed Adjacency List Graph =======\n";
    AdjacencyListGraph listGraph(5, true);

    // Add edges
    listGraph.addEdge(0, 1);
    listGraph.addEdge(0, 4);
    listGraph.addEdge(1, 2);
    listGraph.addEdge(1, 3);
    listGraph.addEdge(1, 4);
    listGraph.addEdge(2, 3);
    listGraph.addEdge(3, 4);

    // Print the graph
    std::cout << "Adjacency List:\n";
    listGraph.printGraph();

    // Test edge existence
    std::cout << "Edge (0,1): " << (listGraph.hasEdge(0, 1) ? "exists" : "doesn't exist") << std::endl;
    std::cout << "Edge (4,0): " << (listGraph.hasEdge(4, 0) ? "exists" : "doesn't exist") << std::endl;

    // Test graph traversal algorithms
    std::cout << "\n======= Testing Graph Algorithms =======\n";

    // DFS
    std::cout << "DFS starting from vertex 0:\n";
    std::vector<bool> visited(5, false);
    GraphAlgorithms::DFS(listGraph, 0, visited);

    // BFS
    std::cout << "\nBFS starting from vertex 0:\n";
    GraphAlgorithms::BFS(listGraph, 0);

    // Connected Components
    std::cout << "\nConnected Components in undirected graph: "
              << GraphAlgorithms::findConnectedComponents(matrixGraph) << std::endl;

    // Bipartite Check
    std::cout << "Is the undirected graph bipartite? "
              << (GraphAlgorithms::isBipartite(matrixGraph) ? "Yes" : "No") << std::endl;

    // Shortest Path
    std::cout << "\nShortest path from vertex 0 to 3:\n";
    std::vector<int> path = GraphAlgorithms::findShortestPath(matrixGraph, 0, 3);
    for (int vertex : path)
    {
        std::cout << vertex << " ";
    }
    std::cout << std::endl;

    // Topological Sort
    std::cout << "\nTopological Sort of the directed graph:\n";
    std::vector<int> topoOrder = GraphAlgorithms::topologicalSort(listGraph);
    for (int vertex : topoOrder)
    {
        std::cout << vertex << " ";
    }
    std::cout << std::endl;

    // Test Strongly Connected Components
    std::cout << "\n======= Testing Strongly Connected Components =======\n";
    AdjacencyListGraph sccGraph(8, true);

    // Add edges to create SCCs
    sccGraph.addEdge(0, 1);
    sccGraph.addEdge(1, 2);
    sccGraph.addEdge(2, 0);
    sccGraph.addEdge(2, 3);
    sccGraph.addEdge(3, 4);
    sccGraph.addEdge(4, 5);
    sccGraph.addEdge(5, 3);
    sccGraph.addEdge(6, 5);
    sccGraph.addEdge(6, 7);
    sccGraph.addEdge(7, 6);

    std::cout << "Graph for SCC test:\n";
    sccGraph.printGraph();

    std::vector<std::vector<int>> sccs = GraphAlgorithms::findStronglyConnectedComponents(sccGraph);

    std::cout << "Strongly Connected Components:\n";
    for (size_t i = 0; i < sccs.size(); i++)
    {
        std::cout << "Component " << i + 1 << ": ";
        for (int vertex : sccs[i])
        {
            std::cout << vertex << " ";
        }
        std::cout << std::endl;
    }
}

int main()
{
    testGraphImplementations();
    return 0;
}