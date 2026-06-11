import java.util.*;
import java.io.*;
public class probC {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int tar=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        int[] og=new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            og[i]=i+1;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                    int t=og[i];
                    og[i]=og[j];
                    og[j]=t;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            int j=i+1;
            int k=n-1;

            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];

                if(sum==tar){
                    System.out.println(og[i]+" "+og[j]+" "+og[k]);
                    return;
                }
                else if(sum<tar){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
       
        System.out.println("-1");





    }
    
}
