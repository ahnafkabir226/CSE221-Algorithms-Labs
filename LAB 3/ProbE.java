
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbE {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int test=Integer.parseInt(st.nextToken());
        for(int t=0;t<test;t++){
            st=new StringTokenizer(br.readLine());
            long a=Long.parseLong(st.nextToken());
            long n=Long.parseLong(st.nextToken());
            long m=Long.parseLong(st.nextToken());
            
            long result=sum(a,n,m);
            out.println(result%m);

        }

        out.close();
        
    }

    public static long sum(long a,long n,long m){
        if(n==0){
            return 0;
        }
        if(n==1){
            return a%m;
        }

        if(n%2==0){
            long div=sum(a,n/2,m);
            long p=pow(a,n/2,m);
            return (div+(p*div)%m)%m;
        }
        else{
            return (sum(a,n-1,m)+pow(a,n,m))%m;
        }



    }

    public static long pow(long a,long n,long m){
        long res=1%m;
        a=a%m;

        while(n>0){
            if((n&1)==1){
                res=(res*a)%m;
            }

            a=(a*a)%m;
            n=n/2;

        }

        return res;
    }




}
