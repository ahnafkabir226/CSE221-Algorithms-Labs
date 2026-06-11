import java.util.*;
import java.io.*;
public class ProbF {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        int i=a-1;
        int j=b-1;
        
        int[] dx={-1,-1,-1,0,0,1,1,1};
        int[] dy={-1,0,1,-1,1,-1,0,1};

        List<String> moves=new ArrayList<>();

        for(int k=0;k<8;k++){
            int ni=i+dx[k];
            int nj=j+dy[k];

            if(ni>=0 && ni<n && nj>=0 && nj<n){
                moves.add((ni+1)+" "+(nj+1));
            }
        }

        out.println(moves.size());
        for(int k=0;k<moves.size();k++){
            out.println(moves.get(k));
        }

        out.close();



    }
}
