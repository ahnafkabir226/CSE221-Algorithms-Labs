import java.io.*;
import java.util.*;
public class ProbG {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        
        int[][] tasks=new int[n][2];
        long sumdead=0;

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            tasks[i][0]=Integer.parseInt(st.nextToken());
            tasks[i][1]=Integer.parseInt(st.nextToken());
            sumdead+=tasks[i][1];
        }

        Arrays.sort(tasks, (a,b)-> Integer.compare(a[0],b[0]));

        long time=0;
        long fsum=0;

        for(int[] t:tasks){
            time+=t[0];
            fsum+=time;
        }

        long ans=sumdead-fsum;
        out.println(ans);
        
        out.close();


    }
}