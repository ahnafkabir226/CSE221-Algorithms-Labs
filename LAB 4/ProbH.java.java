import java.util.*;
import java.io.*;
public class ProbH {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j && gcd(i,j)==1){
                    adj[i].add(j);
                }
            }
        }

        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            if(adj[x].size()<k){
                out.println(-1);
            }
            else{
                out.println(adj[x].get(k-1));
            }

        }

        out.close();

    }

    
    static int gcd(int a,int b){
        while(b!=0){
            a=a%b;
            int temp=a;
            a=b;
            b=temp;
        }

        return a;
    }




}
