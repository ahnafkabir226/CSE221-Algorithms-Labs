import java.io.*;
import java.util.*;

public class ProbA {
    static long[] dist;
    static int[] parent;
    static PrintWriter out=new PrintWriter(System.out);
    
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int src=Integer.parseInt(st.nextToken());
        int dst=Integer.parseInt(st.nextToken());

        dist=new long[n+1];
        parent=new int[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(parent,-1);
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
        for(int i=0;i<m;i++){
            w[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            adj[u[i]].add(new Node(v[i],w[i]));
        }

        Dijk(adj,src);

        if(dist[dst]==Long.MAX_VALUE){
            out.println(-1);
        }
        else{
            out.println(dist[dst]);
            printPath(dst);
        }

        

        out.close();



    }

    static void Dijk(ArrayList<Node>[] adj,int src){
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)-> Long.compare(a.w,b.w));
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
                parent[v]=u;
                pq.add(new Node(v,dist[v]));
            }
           }
        }

    }

    static void printPath(int dst){
        ArrayList<Integer> path=new ArrayList<>();
        
        while(dst!=-1){
            path.add(dst);
            dst=parent[dst];
        }

        Collections.reverse(path);
        for(int i=0;i<path.size();i++){
            out.print(path.get(i)+" ");
        }
    }

    static class Node{
        int v;
        long w;

        Node(int v,long w){
            this.v=v;
            this.w=w;
        }
    }

    
    
} 