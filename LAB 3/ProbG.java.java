import java.util.*;
import java.io.*;
public class ProbG {
    static PrintWriter out=new PrintWriter(System.out);
    static int ind=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[] in=new int[n];
        int[] pre=new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            in[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            pre[i]=Integer.parseInt(st.nextToken());
        }

        postOrd(in, pre, 0, n-1);
        out.close();

        
    }

        public static void postOrd(int[] in,int[] pre,int l,int r){
        if(l>r){
            return;
        }
        int root=pre[ind++];
        int pos=l;
        while(in[pos]!=root){
            pos++;}

            postOrd(in, pre, l, pos-1);
            postOrd(in, pre, pos+1, r);

            out.print(root+" ");

    }

    }

    

