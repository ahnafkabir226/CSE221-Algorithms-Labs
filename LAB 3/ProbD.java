
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbD {

    static long mod=1000000007;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int test=Integer.parseInt(st.nextToken());

        for(int t=0;t<test;t++){
            int[][] mat=new int[2][2];
            st=new StringTokenizer(br.readLine());
            mat[0][0]=Integer.parseInt(st.nextToken());
            mat[0][1]=Integer.parseInt(st.nextToken());
            mat[1][0]=Integer.parseInt(st.nextToken());
            mat[1][1]=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());

            long[][] ans=fastmat(mat,x);

            out.println(ans[0][0]+" "+ans[0][1]);
            out.println(ans[1][0]+" "+ans[1][1]);

        }

        out.close();


    }

    public static long[][] fastmat(int[][] mat,int x){
        long[][] result={{1,0},{0,1}};

        long[][] base={
            {mat[0][0],mat[0][1]},
            {mat[1][0],mat[1][1]}
        };

        while(x>0){
            if((x&1)==1){
                result=mul(result,base);
            }

            base=mul(base,base);
            x=x/2;
        }

        return result;

    }


    public static long[][] mul(long[][] a,long[][] b){
        long[][] res=new long[2][2];

        res[0][0]=(a[0][0]*b[0][0] + a[0][1]*b[1][0])%mod;
        res[0][1]=(a[0][0]*b[0][1] + a[0][1]*b[1][1])%mod;
        res[1][0]=(a[1][0]*b[0][0] + a[1][1]*b[1][0])%mod;
        res[1][1]=(a[1][0]*b[0][1] + a[1][1]*b[1][1])%mod;

        return res;
    }



}
