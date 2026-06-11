import java.io.*;
import java.util.*;
public class ProbD {
    static PrintWriter out=new PrintWriter(System.out);
    static boolean[] vis;
    
    static int[] dist;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        vis=new boolean[n+1];
        dist=new int[n+1];
        parent=new int[n+1];
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        int m=Integer.parseInt(st.nextToken());
        int src=Integer.parseInt(st.nextToken());
        int dst=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        BFS(adj,src);



        if(!vis[k]){
            out.println(-1);
            out.close();
            return;
        }

        int d1=dist[k];
        ArrayList<Integer> p1=getP(k);


        Arrays.fill(vis,false);
        Arrays.fill(dist,0);
        Arrays.fill(parent,-1);
        BFS(adj,k);

        if(!vis[dst]){
            out.println(-1);
            out.close();
            return;
        }
        int d2=dist[dst];
        ArrayList<Integer> p2=getP(dst);
        out.println(d1+d2);

        for(int i=0;i<p1.size();i++){
            out.print(p1.get(i)+" ");
        }
        for(int i=1;i<p2.size();i++){
            out.print(p2.get(i)+" ");
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

    static ArrayList<Integer> getP(int dst){
        ArrayList<Integer> path=new ArrayList<>();

        while(dst!=-1){
            path.add(dst);
            dst=parent[dst];
        }
        Collections.reverse(path);
        return path;
    }



}