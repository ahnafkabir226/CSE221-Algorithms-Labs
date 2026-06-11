import java.io.*;
import java.util.*;
public class ProbA {
    static int[] vis;
    static ArrayList<Integer> topo;
    static boolean cycle;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] adj=new ArrayList[n+1];
            vis=new int[n+1];
            cycle=false;
            topo=new ArrayList<>();
            for(int j=1;j<=n;j++){
                adj[j]=new ArrayList<>();
            }
            for(int j=0;j<m;j++){
                st=new StringTokenizer(br.readLine());
                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
                adj[u].add(v);
            }


            for(int j=1;j<=n;j++){
                if(vis[j]==0){
                    DFS(adj,j);
                }
            }

            if(cycle){
                out.println(-1);
                continue;
            }

           for(int j=topo.size()-1;j>=0;j--){
            out.print(topo.get(j)+" ");
           }
           out.println();
        }

        out.close();

    }

    static void DFS(ArrayList<Integer>[] adj,int u){

        vis[u]=1;

        for(int v:adj[u]){
            if(vis[v]==0){
                DFS(adj,v);
            }
            else if(vis[v]==1){
                cycle=true;
            }
        }
        vis[u]=2;
        topo.add(u);


    }






}
