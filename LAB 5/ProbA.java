import java.io.*;
import java.util.*;

public class ProbA {
    static PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        int m=Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        BFS(adj,n,1);


    }

    static void BFS(ArrayList<Integer>[] adj,int n,int src){
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[n+1];
        q.add(src);
        vis[src]=true;

        while(!q.isEmpty()){
            int u=q.poll();
            out.print(u+" ");

            for(int v:adj[u]){
                if(!vis[v]){
                    vis[v]=true;
                    q.add(v);
                }
            }
        }

        out.close();


    }




}
