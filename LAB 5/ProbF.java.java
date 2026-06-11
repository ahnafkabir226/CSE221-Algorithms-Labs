import java.util.*;
import java.io.*;

public class ProbF {
    static int[] sub;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        sub=new int[n+1];
        DFS(adj,r,-1);

        st=new StringTokenizer(br.readLine());
        int q=Integer.parseInt(st.nextToken());
        for(int i=0;i<q;i++){
            int x=Integer.parseInt(br.readLine());
            out.println(sub[x]);
        }

        out.close();


    }

    static void DFS(ArrayList<Integer>[] adj,int u,int parent){
        sub[u]=1;
        for(int v:adj[u]){
            if(v!=parent){
                DFS(adj,v,u);
                sub[u]+=sub[v];
            }
        }
    }
}
