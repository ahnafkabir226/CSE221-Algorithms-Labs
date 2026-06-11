import java.util.*;
import java.io.*;
public class ProbH {
    static PrintWriter out=new PrintWriter(System.out);
    static int ind;
    static int[] pre;
    static int p=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[] in=new int[n];
        int[] post=new int[n];
        pre=new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            in[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            post[i]=Integer.parseInt(st.nextToken());
        }

        ind=n-1;
        preOrd(in, post, 0, n-1,0);

        for(int i=0;i<n;i++){
            out.print(pre[i]+" ");
        }
        out.close();

        
    }

    public static void preOrd(int[] in,int[] post,int l,int r,int p){
        if(l>r){
            return;
        }

        int root=post[ind--];
        pre[p]=root;
        int pos=l;
        while(in[pos]!=root){
            pos++;
        }

        int lsize=pos-l;

        preOrd(in, post, pos+1, r,p+lsize+1);
        preOrd(in, post, l, pos-1,p+1);

        





    }

}