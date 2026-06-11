import java.io.*;
import java.util.*;

public class ProbF {
    static long[][] dist;
    
    static PrintWriter out=new PrintWriter(System.out);

    static class Node{
        int v;
        long w;

        Node(int v,long w){
            this.v=v;
            this.w=w;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        dist=new long[n+1][2];
        for(long[] row:dist){
            Arrays.fill(row,Long.MAX_VALUE);
        }
        ArrayList<Node>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            long w=Long.parseLong(st.nextToken());

            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u,w));
        }

        Dijk(adj,s);

        if(dist[d][1]==Long.MAX_VALUE){
            out.println(-1);
        }
        else{
            out.println(dist[d][1]);
        }


        out.close();
    }

    static void Dijk(ArrayList<Node>[] adj,int src){
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));

        dist[src][0]=0;
        pq.add(new long[]{0,src});

        while(!pq.isEmpty()){
           long[] curr=pq.poll();
           long currdist=curr[0];
           int u=(int)curr[1];

            if(currdist>dist[u][1]) continue;

            for(Node nei:adj[u]){
                int v=nei.v;
                long newdist=currdist+nei.w;

                if(newdist<dist[v][0]){
                    dist[v][1]=dist[v][0];
                    dist[v][0]=newdist;
                    pq.add(new long[]{newdist,v});
                }
                else if(newdist>dist[v][0] && newdist<dist[v][1]){
                    dist[v][1]=newdist;
                    pq.add(new long[]{newdist,v});
                }
            }
        }


    }
}