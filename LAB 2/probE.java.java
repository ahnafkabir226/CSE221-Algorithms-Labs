import java.util.*;
import java.io.*;
public class probE {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        int k=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int bestc=0;;
        int i=0;
        int j=0;
        int sum=0;
        while(j<n){
            sum+=arr[j];

            while(sum>k && i<=j){
                sum-=arr[i];
                i++;
            }
            
            if((j-i+1)>bestc){
                bestc=j-i+1;
            }
            j++;
        }

       

        out.println(bestc);
        out.close();




    }
}
