import java.util.*;
import java.io.*;
public class ProbB {
    static PrintWriter out=new PrintWriter(System.out);
    static boolean[] vis;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        vis=new boolean[n+1];
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        int m=Integer.parseInt(st.nextToken());
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

        DFS(adj,1);
        out.close();


    }

    static void DFS(ArrayList<Integer>[] adj,int src){
        Stack<Integer> s=new Stack<>();
        s.push(src);

        while(!s.isEmpty()){
            int u=s.pop();
            if(!vis[u]){
                vis[u]=true;
                out.print(u+" ");
            }
            for(int v:adj[u]){
                if(!vis[v]){
                    s.push(v);
                }
            }
        }

    }

}
