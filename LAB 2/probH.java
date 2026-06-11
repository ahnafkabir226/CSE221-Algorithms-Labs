import java.util.*;
import java.io.*;
public class probH {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());

            int a=(k-1)/(x-1);
            out.println(((x*a)+1+((k-1)%(x-1))));
            
        }

        out.close();
        

    
    }
}
