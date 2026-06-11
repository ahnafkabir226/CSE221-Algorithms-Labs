
import java.io.*;
import java.util.*;

public class ProbA {
    static int[] p;
    static int[] size;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        p=new int[n+1];
        size=new int[n+1];
        
        for(int i=1;i<=n;i++){
            p[i]=i;
            size[i]=1;
        }

        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            out.println(union(a,b));
        }

        out.close();

    }

    static int find(int x){
        if(p[x]!=x){
            p[x]=find(p[x]);
        }

        return p[x];
    }


    static int union(int a,int b){
        int pa=find(a);
        int pb=find(b);

        if(pa==pb){
            return size[pa];
        }

        if(size[pa]<size[pb]){
            int temp=pa;
            pa=pb;
            pb=temp;
        }

        p[pb]=pa;
        size[pa]+=size[pb];

        return size[pa];
    }
}
