import java.util.*;
import java.io.*;
public class ProbC {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());
        long mod=107;

        long result=expo(a,b,mod);
        out.println(result);
        out.close();

    }
    public static long expo(long a,long b,long mod){
        long result=1;
        a=a%mod;

        while(b>0){
            if((b&1)==1){
                result=(result*a)%mod;
            }
            a=(a*a)%mod;
            b>>=1;
        }
         return result;
    
    }

   



}
