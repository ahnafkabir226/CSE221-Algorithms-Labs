import java.util.*;
import java.io.*;
public class probD {
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[] arr1=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        int[] arr2=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }


        int p1=0;
        int p2=0;

        while(p1<n && p2<m){
            if(arr1[p1]<=arr2[p2]){
                out.print(arr1[p1++]+" ");
            }
            else{
                out.print(arr2[p2++]+" ");
            }
        }

        while(p1<n){
            out.print(arr1[p1++]+" ");
        }
        


        while(p2<m){
            out.print(arr2[p2++]+" ");
        }

        out.close();
    }
}
