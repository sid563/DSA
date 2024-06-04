import java.util.*;
public class TryGraph {
        static class Edge{
                int src;
                int dest;
                int weight;
                Edge(int s, int d, int w){
                        src=s;
                        dest=d;
                        weight=w;

                }
        }

        static void createGraph(ArrayList<Edge> graph[] ){
                for(int i=0;i<graph.length;i++){
                        graph[i]=new ArrayList<>();
                }
                graph[0].add(new Edge(0, 1, 0));
                graph[0].add(new Edge(0, 2, 0));
                graph[1].add(new Edge(1, 0, 0));
                graph[1].add(new Edge(1, 3, 0));
                graph[2].add(new Edge(2, 0, 0));
                graph[2].add(new Edge(2, 4, 0));
                graph[3].add(new Edge(3, 1, 0));
                graph[3].add(new Edge(3, 4, 0));
                graph[3].add(new Edge(3, 5, 0));
                graph[4].add(new Edge(4, 2, 0));
                graph[4].add(new Edge(4, 3, 0));
                graph[4].add(new Edge(4, 5, 0));
                graph[5].add(new Edge(5, 3, 0));
                graph[5].add(new Edge(5, 4, 0));
                graph[5].add(new Edge(5, 6, 0));
                graph[6].add(new Edge(6, 5, 0));
        }

        public static void main(String[] args) {
                int V=7;
                ArrayList<Edge> graph[]=new ArrayList[V];
                createGraph(graph);
                //ArrayList<Edge> e=graph[3];
                // System.out.println("Neighbors of Node 3:");
                // for(int i=0;i<graph[3].size();i++){
                //         Edge e=graph[3].get(i);
                //         System.out.println(e.dest);
                // }

                //BFS
               //bfs(graph);
               boolean[] vis=new boolean[V];
               //int curr=0;
               mydfs(graph,0,vis);


        }

        private static void mydfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
                System.out.println(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                        Edge e=graph[curr].get(i);
                        if(!vis[e.dest]){
                                mydfs(graph, e.dest, vis);
                        }
                }
              //  throw new UnsupportedOperationException("Unimplemented method 'mydfs'");
        }

        private static void bfs(ArrayList<Edge>[] graph) {
                // TODO Auto-generated method stub
                int V=graph.length;
               // System.out.println();
                boolean arr[]=new boolean[V];
                Queue<Integer> queue=new LinkedList<>();
                queue.add(0);
                while(!queue.isEmpty()){
                        int p=queue.remove();
                        if(!arr[p]){
                                System.out.print(p+" ");
                                arr[p]=true;
                                for(int i=0;i<graph[p].size();i++){
                                        Edge e=graph[p].get(i);
                                        queue.add(e.dest);

                                }

                        }
                }
               // throw new UnsupportedOperationException("Unimplemented method 'bfs'");
        }
}
