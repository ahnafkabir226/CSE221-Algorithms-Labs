import java.io.*;
import java.util.*;
public class ProbH {

    static int r;
    static int c;
    static char[][] mat;
    static boolean[][] vis;

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        mat=new char[r][c];
        vis=new boolean[r][c];

        for(int i=0;i<r;i++){
            String s=br.readLine();
            for(int j=0;j<c;j++){
                mat[i][j]=s.charAt(j);
            }
        }

        int res=0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]!='#' && !vis[i][j]){
                    res=Math.max(res,BFS(i,j));
                }
            }
        }

        out.println(res);
        out.close();

    }

    static int BFS(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {x,y});
        vis[x][y]=true;

        int count=0;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int i=curr[0];
            int j=curr[1];

            if(mat[i][j]=='D'){
                count++;
            }

            for(int k=0;k<4;k++){
                int ni=i+dx[k];
                int nj=j+dy[k];

                if(ni>=0 && ni<r && nj>=0 && nj<c && !vis[ni][nj] && mat[ni][nj]!='#'){
                    vis[ni][nj]=true;
                    q.add(new int[]{ni,nj});
                }
            }
        }

        return count;
    }

}
