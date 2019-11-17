package geektime.graph_31;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: sunguangchao
 * @Date: 2019/11/10 11:42 AM
 * 无向图
 */
public class Graph {
    /**
     * 顶点个数
     */
    private int v;
    /**
     * LinkedList的一个数组
     */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先遍历
     * Breadth-First-Search
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //用来记录已经被访问的节点
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //已经被访问的节点，相邻的下一层要被访问的节点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //记录搜索路径
        int[] prev = new int[v];
        //初始化，将prev置为-1
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            //取出被访问的节点
            int w = queue.poll();
            //遍历此结点的相邻节点
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                //没有被访问过的，才继续访问
                if (!visited[q]) {
                    //记录是从w节点过来的
                    prev[q] = w;
                    //找到终止节点，访问结束
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    //塞到队列，供下一次继续访问
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }

    /**
     * 深度优先搜索找到终点t之后，不需要再继续搜索
     */
    boolean found = false;


    /**
     * 深度优先搜索
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);

    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]){
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(2, 5);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.bfs(0, 6);
        graph.dfs(0,6);
    }
}
