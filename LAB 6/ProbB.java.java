import java.io.*;
import java.util.*;
public class ProbB {
    static int[] color;
    static int c0;
    static int c1;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        color=new int[n+1];
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        Arrays.fill(color,-1);

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        int ans=0;

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                c0=0;
                c1=0;
                DFS(adj,i,0);
                ans+=Math.max(c0,c1);
            }
        }

        out.println(ans);
        out.close();

    }

    static void DFS(ArrayList<Integer>[] adj,int u,int c){
        color[u]=c;
        if(c==0)c0++;
        else c1++;


        for(int v:adj[u]){
            if(color[v]==-1){
                DFS(adj,v,1-c);
            }
        }
    }
}
