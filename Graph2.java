import java.util.*;
public class Graph2 {
        static class Edge {
                int src;
                int dest;
                int wt;
                public Edge(int s, int d, int w) {
                        this.src = s;
                        this.dest = d;
                        this.wt = w;


                }
        }
        static void createGraph(ArrayList<Edge> graph[]) {
                for(int i=0; i<graph.length; i++) {
                        graph[i] = new ArrayList<>();
                        }
                        graph[0].add(new Edge(0, 1, 1));
                        graph[0].add(new Edge(0, 2, 1));
                        graph[1].add(new Edge(1, 0, 1));
                        graph[1].add(new Edge(1, 3, 1));
                        graph[2].add(new Edge(2, 0, 1));

                        graph[2].add(new Edge(2, 4, 1));
                        graph[3].add(new Edge(3, 1, 1));
                        graph[3].add(new Edge(3, 4, 1));
                        graph[3].add(new Edge(3, 5, 1));
                        graph[4].add(new Edge(4, 2, 1));
                        graph[4].add(new Edge(4, 3, 1));
                        graph[4].add(new Edge(4, 5, 1));
                        graph[5].add(new Edge(5, 3, 1));
                        graph[5].add(new Edge(5, 4, 1));
                        graph[5].add(new Edge(5, 6, 1));
                        graph[5].add(new Edge(6, 5, 1));
        }
        public static void bfs(ArrayList<Edge> graph[], int V) {
                boolean visited[] = new boolean[V];
                Queue<Integer> q = new LinkedList<>();
                q.add(0); //Source = 0
                while(!q.isEmpty()) {
                        int curr = q.remove();
                        if(!visited[curr]) {
                                System.out.print(curr+" ");
                                visited[curr] = true;
                                for(int i=0; i<graph[curr].size(); i++) {
                                        Edge e = graph[curr].get(i);
                                        q.add(e.dest);
                                }
                        }
                }
                System.out.println();
        }
        public static void dfs(ArrayList<Edge> graph[], int start,boolean vis[]){
                System.out.print(start+" ");
                vis[start]=true;
                for(int i=0;i<graph[start].size();i++){
                        Edge e=graph[start].get(i);
                        if(vis[e.dest]==false){
                                dfs(graph, e.dest, vis);
                        }
                }
        }

        public static void mybfs(ArrayList<Edge> graph[], int start,boolean vis[]){
                Queue<Integer> q=new LinkedList<>();
               // System.out.println(start+" ");
               q.add(start);
               while(!q.isEmpty()){
                        int curr=q.remove();
                        if(vis[curr]==false){
                                System.out.println(curr);
                                vis[curr]=true;
                                for(int i=0;i<graph[curr].size();i++){
                                        Edge e=graph[curr].get(i);
                                        q.add(e.dest);
                                }
                        }
               }


        }

        public static void allPath(ArrayList<Edge> graph[] , String path,boolean vis[], int curr, int tar){
                if(curr==tar){
                        System.out.println(path);
                        return;
                }

                for(int i=0;i<graph[curr].size();i++){
                        Edge e=graph[curr].get(i);
                        if(vis[e.dest]==false){
                                vis[curr]=true;
                                allPath(graph, path+e.dest, vis, e.dest, tar); 
                                vis[curr]=false;

                        }
                }
        }
        public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

             /*
                 1 --- 3
                /      | \
               0       |  5 -- 6
                \      | /
                2 ---- 4
                */

        // print 2's neighbors

        // for(int i=0;i<graph[2].size();i++){
        //         Edge e=graph[2].get(i);
        //         System.out.println(e.dest);
        // }
        //bfs(graph, V);
        boolean vis[]=new boolean[V];
       // dfs(graph, 0, vis);
        //mybfs(graph,0, vis);


        //if graph is broken
        // for(int i=0;i<V;i++){
        //         if(vis[i]==false){
        //                 mybfs(graph,i, vis);
        //         }
        // }

        allPath(graph,"0", vis, 0, 5);




        }
}
