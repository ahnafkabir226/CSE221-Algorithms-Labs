import java.util.*;
import java.io.*;
public class ProbG {
   public static void main(String[] args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out=new PrintWriter(System.out);
    StringTokenizer st=new StringTokenizer(br.readLine());

    int n=Integer.parseInt(st.nextToken());
    int m=Integer.parseInt(st.nextToken());
    int k=Integer.parseInt(st.nextToken());

    boolean[][] brd=new boolean[n+1][m+1];
    int[] x=new int[k];
    int[] y=new int[k];

    for(int i=0;i<k;i++){
        st=new StringTokenizer(br.readLine());
        x[i]=Integer.parseInt(st.nextToken());
        y[i]=Integer.parseInt(st.nextToken());
        brd[x[i]][y[i]]=true;
    }

    int[] dx={1,-1,2,2,1,-1,-2,-2};
    int[] dy={-2,-2,-1,1,2,2,1,-1};

    for(int i=0;i<k;i++){
        int ix=x[i];
        int iy=y[i];

        for(int j=0;j<8;j++){
            int nx=ix+dx[j];
            int ny=iy+dy[j];

            if(nx>=1 && nx<=n && ny>=1 && ny<=m){
                if(brd[nx][ny]){
                    out.println("YES");
                    out.close();
                    return;
                }
            }
        }
    }

    out.println("NO");
    out.close();





   } 
}
