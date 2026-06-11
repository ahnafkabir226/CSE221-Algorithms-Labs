import java.io.*;
import java.util.*;
public class ProbF {
    static PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        preOrd(arr,0,n-1);
        out.close();

    }

    public static void preOrd(int[] arr,int l,int r){
        if(l>r){
            return;
        }
        int mid=(l+r)/2;
        out.print(arr[mid]+" ");

        preOrd(arr,l,mid-1);
        preOrd(arr,mid+1,r);

    }
}
