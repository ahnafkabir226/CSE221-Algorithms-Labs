import java.io.*;
import java.util.*;

public class ProbC {
    static long[] dist;
    
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

        dist=new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
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

        Dijk(adj,1);
        for(int i=1;i<=n;i++){
            if(dist[i]==Long.MAX_VALUE){
                out.print(-1+" ");
            }
            else{
                out.print(dist[i]+" ");
            }            
        }

        out.close();
    }

    static void Dijk(ArrayList<Node>[] adj,int src){
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->Long.compare(a.w,b.w));

        dist[src]=0;
        pq.add(new Node(src,dist[src]));

        while(!pq.isEmpty()){
            Node curr=pq.poll();
            int u=curr.v;

            if(curr.w>dist[u]) continue;

            for(Node nei:adj[u]){
                int v=nei.v;
                long w=nei.w;

                if(dist[v]>Math.max(dist[u],w)){
                    dist[v]=Math.max(dist[u],w);
                    pq.add(new Node(v,dist[v]));
                }
            }
        }


    }








}