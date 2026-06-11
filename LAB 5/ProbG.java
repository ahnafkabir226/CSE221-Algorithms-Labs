import java.util.*;
import java.io.*;
public class ProbG {
    static int[] color;
    static PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        color=new int[n+1];
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        boolean cycle=false;

        for(int i=1;i<=n;i++){
            if(DFS(adj, i)){
                cycle=true;
                break;
            }
        }

        if(cycle) out.println("YES");
        else out.println("NO");

        out.close();

    }

    static boolean DFS(ArrayList<Integer>[] adj,int u){
        color[u]=1;

        for(int v:adj[u]){
            if(color[v]==0){
                if(DFS(adj, v)){
                    return true;
                }
            }
            else if(color[v]==1){
                return true;
            }
        }

        color[u]=2;
        return false;

    }




}
