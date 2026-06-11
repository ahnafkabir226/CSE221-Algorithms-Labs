import java.io.*;
import java.util.*;
public class ProbC {
    static PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[][] edge=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            for(int j=0;j<m;j++){
                int v=Integer.parseInt(st.nextToken());
                edge[i][v]=1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                out.print(edge[i][j]+" ");
            }
            out.println();
        }

        out.close();



    }
}