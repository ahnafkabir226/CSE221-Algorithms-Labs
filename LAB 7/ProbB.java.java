import java.io.*;
import java.util.*;

public class ProbB {
    
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
        int t=Integer.parseInt(st.nextToken());

        long[] distS=new long[n+1];
        long[] distT=new long[n+1];

        Arrays.fill(distS,Long.MAX_VALUE);
        Arrays.fill(distT,Long.MAX_VALUE);
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
        }

        Dijk(adj,s,distS);
        Dijk(adj,t,distT);

        long res=Long.MAX_VALUE;
        int mnode=Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            if(distS[i]==Long.MAX_VALUE || distT[i]==Long.MAX_VALUE) continue;

            long time=Math.max(distS[i],distT[i]);
            if(time<res || (time==res && i<mnode)){
                res=time;
                mnode=i;
            }
        }

        if(mnode==Integer.MAX_VALUE){
            out.println(-1);
        }
        else{
            out.println(res+" "+mnode);
        }

        out.close();


    }

    static void Dijk(ArrayList<Node>[] adj,int src,long[] dist){
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->Long.compare(a.w,b.w));
        dist[src]=0;
        pq.add(new Node(src,0));

        while(!pq.isEmpty()){
            Node curr=pq.poll();
            int u=curr.v;

            if(curr.w>dist[u]) continue;

            for(Node nei:adj[u]){
                int v=nei.v;
                long w=nei.w;

                if(dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                    pq.add(new Node(v,dist[v]));
                }
            }
        }



    }



    
}