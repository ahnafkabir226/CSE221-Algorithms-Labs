import java.io.*;
import java.util.*;

public class ProbB {
    static int[] p;
    static int[] size;

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
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
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

        long count=0;
        int used=0;
        for(int i=0;i<m && used<n-1;i++){
            if(union(edges[i][0],edges[i][1])){
                count+=edges[i][2];
                used++;
            }
        }

        out.print(count);
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





}