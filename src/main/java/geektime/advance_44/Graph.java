package geektime.advance_44;

import java.util.LinkedList;

/**
 * Created by 11981 on 2019/12/8.
 */
public class Graph {
    /**
     * 邻接表
     */
    private LinkedList<Edge> adj[];

    /**
     * 顶点个数
     */
    private int v;

    /**
     * 初始化
     * @param v
     */
    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    /**
     * 从顶点s到顶点t的最短距离
     * Vertex:顶点
     * @param s
     * @param t
     *
     * 我们从优先级队列中取出 dist 最小的顶点 minVertex，然后考察这个顶点可达的所有顶点（代码中的 nextVertex）。
     * 如果 minVertex 的 dist 值加上 minVertex 与 nextVertex 之间边的权重 w 小于 nextVertex 当前的 dist 值，
     * 也就是说，存在另一条更短的路径，它经过 minVertex 到达 nextVertex。那我们就把 nextVertex 的 dist
     * 更新为 minVertex 的 dist 值加上 w。然后，我们把 nextVertex 加入到优先级队列中。重复这个过程，直到找到终止顶点 t 或者队列为空。
     */
    public void dijkstra(int s, int t){
        //用来还原最短路径
        int[] predecessor = new int[this.v];
        Vertex[] vertexes = new Vertex[this.v];
        for (int i = 0; i < this.v; i++) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue queue = new PriorityQueue(this.v);//小顶堆
        boolean[] inqueue = new boolean[this.v];//标记是否进入过队列
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()){
            //取堆顶元素并删除
            Vertex minVertex = queue.poll();
            //最短路径产生了
            if (minVertex.id == t){
                break;
            }
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                //取出一条minVertex相连的边
                Edge e = adj[minVertex.id].get(i);
                //minVertex -> nextVertex
                Vertex nextVertex = vertexes[e.tid];
                //更新next的dist
                if (minVertex.dist + e.w < nextVertex.dist){
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id]){
                        queue.update(nextVertex);
                    }else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        System.out.println(s);
        print(s, t, predecessor);
    }


    private void print(int s, int t, int[] predecessor) {
        if (s == t) {
            return;
        }
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }




    private class Edge{
        /**
         * 边的起始顶点编号
         */
        private int sid;
        /**
         * 边的终止顶点编号
         */
        private int tid;
        /**
         * 权重
         */
        private int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }


    }

    /**
     * Created by 11981 on 2019/12/8.
     * 因为Java提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
     */
    public class PriorityQueue {

        private Vertex[] nodes;

        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }

        public Vertex poll() {
            return nodes[count];
        }

        public void add(Vertex vertex) {

        }

        public void update(Vertex vertex) {
            // TODO: 留给读者实现...
        }

        public boolean isEmpty() {
            return count == 0;
        }



    }

    public class Vertex {
        public int id;//顶点编号ID
        public int dist;//从起始顶点到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }
}
