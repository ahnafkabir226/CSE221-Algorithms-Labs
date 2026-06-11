import java.io.*;
import java.util.*;

public class ProbE {
    static long[][] dist;
    static PrintWriter out=new PrintWriter(System.out);

    static class Node{
        int v;
        long w;
        int parity;

        Node(int v,long w,int parity){
            this.v=v;
            this.w=w;
            this.parity=parity;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        dist=new long[n+1][2];

        for(long[] row:dist){
            Arrays.fill(row,Long.MAX_VALUE);
        }

        int[] u=new int[m];
        int[] v=new int[m];
        int[] w=new int[m];

        ArrayList<Node>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            u[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0 ;i<m;i++){
            w[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            int parity=w[i]%2;
            adj[u[i]].add(new Node(v[i],w[i],parity));
        }

        Dijk(adj,1);

        long res=Math.min(dist[n][0],dist[n][1]);

        if(res==Long.MAX_VALUE){
            out.println(-1);
        }
        else{
            out.println(res);
        }

        out.close();


    }


    static void Dijk(ArrayList<Node>[] adj,int src){
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->Long.compare(a.w,b.w));
        dist[src][0]=0;
        dist[src][1]=0;
        pq.add(new Node(src,0,-1));

        while(!pq.isEmpty()){
            Node curr=pq.poll();
            int u=curr.v;
            int lp=curr.parity;
            long currdist=curr.w;

            if(lp!=-1 && currdist>dist[u][lp]) continue;

            for(Node nei:adj[u]){
                int v=nei.v;
                long w=nei.w;
                int p=nei.parity;

                if(lp!=-1 && p==lp) continue;

                if(dist[v][p]>currdist+w){
                    dist[v][p]=currdist+w;
                    pq.add(new Node(v,dist[v][p],p));
                }
            }
        }






    }
}