import java.util.*;
import java.io.*;
public class probG {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        int[] arr=new int[n];
        // int[][] pair=new int[q][2];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            int a=start(arr,x);
            int b=last(arr,y);

            int count=0;
            if((b-a)>0){
                count=b-a;
            }

            out.println(count);
        }

        out.close();

    }


    public static int start(int[] arr,int x){
        int i=0;
        int j=arr.length;
        while(i<j){
            int mid=(i+j)/2;
            if(arr[mid]>=x){
                j=mid;
            }
            else{
                i=mid+1;
            }
        }
        return i;
    }

    public static int last(int[] arr,int y){
        int i=0;
        int j=arr.length;
        while(i<j){
            int mid=(i+j)/2;
            if(arr[mid]>y){
                j=mid;
            }
            else{
                i=mid+1;
            }
        }
        return i;
    }


}
