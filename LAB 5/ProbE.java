
import java.io.*;
import java.util.*;

public class ProbE {
    static PrintWriter out=new PrintWriter(System.out);
    static int[] vis;
    static int marker=1;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        vis=new int[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        int m=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());


        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i=1;i<=n;i++){
            if(vis[i]==0){
                BFS(adj,i);
                marker++;
            }
        }



        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            if(vis[x]==vis[y]){
                out.println("YES");
            }
            else{
                out.println("NO");
            }
        }

        out.close();



    }

    static void BFS(ArrayList<Integer>[] adj,int src){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        vis[src]=marker;

        while(!q.isEmpty()){
            int u=q.poll();

            for(int v:adj[u]){
                if(vis[v]==0){
                    vis[v]=marker;
                    q.add(v);
                }
            }
        }

    }
}