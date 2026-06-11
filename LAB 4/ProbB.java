import java.io.*;
import java.util.*;
public class ProbB {
    static PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] edge=new int[3][m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            edge[0][i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            edge[1][i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            edge[2][i]=Integer.parseInt(st.nextToken());
        }

        adjList(edge,n,m);



    }

    static void adjList(int[][] edge,int n,int m){
        for(int i=1;i<=n;i++){
            out.print(i+": ");
            for(int j=0;j<m;j++){
                if(edge[0][j]==i){
                    out.print("("+edge[1][j]+","+edge[2][j]+") ");
                }
            }
            out.println();
        }
        out.close();
    }




}
