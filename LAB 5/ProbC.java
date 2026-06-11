import java.io.*;
import java.util.*;
public class ProbC {
    static PrintWriter out=new PrintWriter(System.out);
    static boolean[] vis;
    static int[] parent;
    static int[] dist;
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        vis=new boolean[n+1];
        parent=new int[n+1];
        dist=new int[n+1];
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        int m=Integer.parseInt(st.nextToken());
        int src=Integer.parseInt(st.nextToken());
        int dst=Integer.parseInt(st.nextToken());
        int[] u=new int[m];
        int[] v=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            u[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            adj[u[i]].add(v[i]);
            adj[v[i]].add(u[i]);
        }

        for(int i=1;i<=n;i++){
            Collections.sort(adj[i]);
        }

        BFS(adj,src);
        
        if(!vis[dst]){
            out.println(-1);
        }
        else{
            out.println(dist[dst]);
            printP(dst);
        }
        
        out.close();

    }

    static void BFS(ArrayList<Integer>[] adj,int src){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        vis[src]=true;
        parent[src]=-1;
        dist[src]=0;

        while(!q.isEmpty()){
            int u=q.poll();
            
            for(int v:adj[u]){
                if(!vis[v]){
                    q.add(v);
                    vis[v]=true;
                    dist[v]=(dist[u])+1;
                    parent[v]=u;
                }
            }
        }
    }

    static void printP(int dst){
        ArrayList<Integer> path=new ArrayList<>();

        while(dst!=-1){
            path.add(dst);
            dst=parent[dst];
        }
        for(int i=path.size()-1;i>=0;i--){
            out.print(path.get(i));
            if(i>0)out.print(" ");
        }

        out.close();
    }
    

}
