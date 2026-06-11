import java.io.*;
import java.util.*;
public class ProbD {
    static int[]p;
    static int[] size;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int t=Integer.parseInt(st.nextToken());

        while(t-- >0){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());

            int[] u=new int[m];
            int[] v=new int[m];
            int[] w=new int[m];

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

            Integer[] idx=new Integer[m];
            for(int i=0;i<m;i++){
                idx[i]=i;
            }

            Arrays.sort(idx,(a,b)->w[b]-w[a]);

            p=new int[n+1];
            size=new int[n+1];
            for(int i=1;i<=n;i++){
                p[i]=i;
                size[i]=1;
            }

            int ans=0;
            for(int i=0;i<m;i++){
                int ei=idx[i];
                union(u[ei],v[ei]);

                if(find(s)==find(d)){
                    ans=w[ei];
                    break;
                }
            }

            out.println(ans);
           



        }
        out.close();


    }

    static int find(int x){
        if(p[x]!=x){
            p[x]=find(p[x]);
        }

        return p[x];
    }

    static void union(int a,int b){
        int pa=find(a);
        int pb=find(b);

        if(pa==pb){
            return;
        }

        if(size[pa]<size[pb]){
            int temp=pa;
            pa=pb;
            pb=temp;
        }

        p[pb]=pa;
        size[pa]+=size[pb];

    }


}