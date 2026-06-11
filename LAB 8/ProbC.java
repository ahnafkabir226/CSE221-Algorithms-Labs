import java.io.*;
import java.util.*;
public class ProbC {
    static int[]p;
    static int[] size;

    static ArrayList<int[]>[] adj;
    static int[][] max1;
    static int[][] max2;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] edges=new int[m][3];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            edges[i][0]=Integer.parseInt(st.nextToken());
            edges[i][1]=Integer.parseInt(st.nextToken());
            edges[i][2]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges,(a,b)-> a[2]-b[2]);

        p=new int[n+1];
        size=new int[n+1];
        for(int i=1;i<=n;i++){
            p[i]=i;
            size[i]=1;
        }

        adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        boolean[] mst=new boolean[m];
        long cost=0;
        int used=0;

        for(int i=0;i<m && used<n-1;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];

            if(union(u,v)){
                mst[i]=true;
                cost+=w;
                used++;

                
                adj[u].add(new int[]{v,w});
                adj[v].add(new int[]{u,w});
            }
        }

        if(used<n-1){
            out.println(-1);
            out.close();
            return;
        }

        max1=new int[n+1][n+1];
        max2=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(max1[i],-1);
            Arrays.fill(max2[i],-1);
        }

        for(int i=1;i<=n;i++){
            BFS(i);
        }

        long best2=Long.MAX_VALUE;
        for(int i=0;i<m;i++){
            if(mst[i]) continue;

            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];

            int mx1=max1[u][v];
            int mx2=max2[u][v];

            
            if(w>mx1){
                best2=Math.min(best2,cost-mx1+w);
            }
            else if(w==mx1 && mx2!=-1){
                best2=Math.min(best2,cost-mx2+w);
            }
        }

        if(best2==Long.MAX_VALUE) out.println(-1);
        else out.println(best2);

        out.close();


    }


    static int find(int x){
        if(p[x]!=x){
            p[x]=find(p[x]);
        }

        return p[x];
    }

    static boolean union(int a,int b){
        int pa=find(a);
        int pb=find(b);

        if(pa==pb){
            return false;
        }

        if(size[pa]<size[pb]){
            int temp=pa;
            pa=pb;
            pb=temp;
        }

        p[pb]=pa;
        size[pa]+=size[pb];

        return true;
    }


    static void BFS(int src){
        boolean[] vis=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        vis[src]=true;

        while(!q.isEmpty()){
            int u=q.poll();

            for(int[] nb:adj[u]){
                int v=nb[0];
                int w=nb[1];

                if(!vis[v]){
                    vis[v]=true;

                    int a=max1[src][u];
                    int b=max2[src][u];

                    if(a==-1){
                        max1[src][v]=w;
                        max2[src][v]=-1;
                    }
                    else if(w>a){
                        max1[src][v]=w;
                        max2[src][v]=a;
                    }
                    else if(w<a){
                        max1[src][v]=a;
                        max2[src][v]=Math.max(b,w);
                    }
                    else{
                        max1[src][v]=a;
                        max2[src][v]=b;
                    }

                    q.add(v);
                }
            }
        }
    }
}
