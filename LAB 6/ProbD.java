import java.io.*;
import java.util.*;
public class ProbD {
    static int[] dist;
    static boolean[] vis;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        dist=new int[n+1];
        vis=new boolean[n+1];

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        BFS(adj,1);
        int d1=0;
        int n1=1;

        for(int i=1;i<=n;i++){
            if(dist[i]>d1){
                d1=dist[i];
                n1=i;
            }
        }

        Arrays.fill(vis,false);
        Arrays.fill(dist,0);

        BFS(adj,n1);
        int d2=0;
        int n2=1;

        for(int i=1;i<=n;i++){
            if(dist[i]>d2){
                d2=dist[i];
                n2=i;
            }
        }

        out.println(Math.max(d1,d2));
        out.println(n1+" "+n2);
        out.close();;


    }

    static void BFS(ArrayList<Integer>[] adj,int src){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        vis[src]=true;
        dist[src]=0;

        while(!q.isEmpty()){
            int u=q.poll();

            for(int v:adj[u]){
                if(!vis[v]){
                    q.add(v);
                    vis[v]=true;
                    dist[v]=dist[u]+1;
                }
            }
        }

    }




}