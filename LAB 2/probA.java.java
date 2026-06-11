import java.io.*;
import java.util.*;
public class probA {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        int s=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int i=0;
        int j=n-1;
        while(i<j){
            if(arr[i]+arr[j]<s){
                i++;
            }
            else if(arr[i]+arr[j]>s){
                j--;
            }
            else{
                System.out.println((i+1)+" "+(j+1));
                return;
            }
        }
        System.out.println("-1");

    }
}
