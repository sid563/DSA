import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Graphdemo {
        public static class Edge{
                int src;
                int dest;
                int weight;
                Edge(int s,int d, int w){
                        src=s;
                        dest=d;
                        weight=w;
                }
        }

        public static void createGraph(ArrayList<Edge> graph[]){

                for(int i=0;i<graph.length;i++){
                        graph[i]=new ArrayList<>();
                }

                graph[0].add(new Edge(0, 2, 2));
                graph[0].add(new Edge(0, 1, 2));
                graph[1].add(new Edge(1, 0, 2));
                graph[1].add(new Edge(1, 3, 2));
                graph[2].add(new Edge(2, 0, 2));
                graph[2].add(new Edge(2, 4, 2));
                graph[3].add(new Edge(3, 1, 2));
                graph[3].add(new Edge(3, 4, 2));
                graph[3].add(new Edge(3, 5, 2));
                graph[4].add(new Edge(4, 2, 2));
                graph[4].add(new Edge(4, 3, 2));
                graph[4].add(new Edge(4, 5, 2));
                graph[5].add(new Edge(5, 3, 2));
                graph[5].add(new Edge(5, 4, 2));
                graph[5].add(new Edge(5, 6, 2));
                graph[6].add(new Edge(6, 5, 2));

        }
        static void bfs (ArrayList<Edge> graph[] , int start, int V){
                Queue<Integer> q=new LinkedList<>();
                boolean [] status=new boolean[V];
                q.add(start);
                while (!q.isEmpty()) {
                        int n=q.remove();
                        if(!status[n]){
                                System.out.print(n+" ");
                                status[n]=true;
                                for(int i=0;i<graph[n].size();i++){
                                        Edge e=graph[n].get(i);
                                        q.add(e.dest);
                                }
                        }
                }
        }
        static void dfs (ArrayList<Edge> graph[] , int curr, boolean []status){
               
                System.out.print(curr+" ");
                status[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                        Edge e=graph[curr].get(i);
                        if(!status[e.dest]){
                                dfs(graph, e.dest, status);
                        }
                }
        }



        public static void main(String[] args){
                int V=7;
                ArrayList<Edge> graph[]=new ArrayList[V];

                createGraph(graph);
                // for(int i=0;i<graph[3].size();i++){
                //         Edge e=graph[3].get(i);
                //         System.out.print(e.dest+" ");
                // }

                //BFS
              //  bfs(graph,0,V);
                boolean[] status=new boolean[V];
                dfs (graph,0,status);


        }
}
