import java.io.*;
import java.util.*;
public class ProbE {
    static boolean[] vis;
    static int[] dist;

     static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args)throws Exception{
        FastScanner fs=new FastScanner();
        
        int n=fs.nextInt();
        vis=new boolean[n+1];
        dist=new int[n+1];
        Arrays.fill(dist,-1);
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        int m=fs.nextInt();
        int s=fs.nextInt();
        int[] src=new int[s];
        int d=fs.nextInt();
        int[] dst=new int[d];

        for(int i=0;i<m;i++){
            int u=fs.nextInt();
            int v=fs.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i=0;i<s;i++){
            src[i]=fs.nextInt();
        }

        for(int i=0;i<d;i++){
            dst[i]=fs.nextInt();
        }

        Queue<Integer> q=new ArrayDeque<>(n);

        for(int i=0;i<s;i++){
            int x=src[i];
            if(dist[x]==-1){
                q.add(x);
                dist[x]=0;
            }
        }
        

            while(!q.isEmpty()){
                int u=q.poll();
                for(int v:adj[u]){
                    if(dist[v]==-1){
                        q.add(v);
                        dist[v]=dist[u]+1;
                    }
                }
            }
        



        StringBuilder sb=new StringBuilder();

        for(int i=0;i<d;i++){
            sb.append(dist[dst[i]]+" ");
        }

        System.out.println(sb.toString());

    }

    




}
