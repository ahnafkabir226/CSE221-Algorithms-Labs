import java.util.*;
import java.io.*;
public class ProbE {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] freq=new int[n+1];

        st=new StringTokenizer(br.readLine());
        int[] u=new int[m];
        for(int i=0;i<m;i++){
            u[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        int[] v=new int[m];
        for(int i=0;i<m;i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            freq[u[i]]--;
            freq[v[i]]++;
        }

        for(int i=1;i<n+1;i++){
            out.print(freq[i]+" ");
        }

        out.close();




    }
}
