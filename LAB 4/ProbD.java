import java.io.*;
import java.util.*;
public class ProbD {
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
            if(u[i]==v[i]){
                freq[u[i]]+=2;
            }
            else{
                freq[u[i]]++;
                freq[v[i]]++;
            }
        }

        int count=0;
        for(int i=0;i<n+1;i++){
            if(freq[i]%2!=0){
                count++;
            }
        }

        if(count==2 || count==0){
            out.println("YES");
        }
        else{
            out.println("NO");
        }

        out.close();
        


    }
}
