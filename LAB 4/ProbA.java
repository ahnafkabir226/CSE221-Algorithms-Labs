import java.io.*;
import java.util.*;
public class ProbA {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] edge=new int[m][3];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            edge[i][0]=Integer.parseInt(st.nextToken());
            edge[i][1]=Integer.parseInt(st.nextToken());
            edge[i][2]=Integer.parseInt(st.nextToken());
        }

        int[][] result=adjMat(edge,n,m);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                out.print(result[i][j]+" ");
            }
            out.println();
        }

        out.close();


    }

    static int[][] adjMat(int[][] edge,int n,int m){
        int[][] adj=new int[n][n];

        for(int i=0;i<m;i++){
            adj[edge[i][0]-1][edge[i][1]-1]=edge[i][2];
        }

        return adj;


    }
}
