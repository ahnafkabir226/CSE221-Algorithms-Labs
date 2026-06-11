import java.io.*;
import java.util.*;
public class ProbC {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int x1=Integer.parseInt(st.nextToken());
        int y1=Integer.parseInt(st.nextToken());
        int x2=Integer.parseInt(st.nextToken());
        int y2=Integer.parseInt(st.nextToken());
        
        int[] dx={2,2,-2,-2,1,1,-1,-1};
        int[] dy={1,-1,1,-1,2,-2,2,-2};

        int[][] dist=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(dist[i],-1);
        }

        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{x1,y1});
        dist[x1][y1]=0;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];

            if(x==x2 && y==y2){
                out.println(dist[x][y]);
                out.close();
                return;
            }

            for(int i=0;i<8;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx>=1&&nx<=n && ny>=1&&ny<=n && dist[nx][ny]==-1){
                    dist[nx][ny]=dist[x][y]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        out.println(-1);
        out.close();

    }

}
