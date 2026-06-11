import java.util.*;
import java.io.*;
public class probB {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr1=new int[n];
        int[] arr2=new int[m];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }

        int i=0;
        int j=m-1;
        int bestdiff=Integer.MAX_VALUE;
        int bestI=0;
        int bestJ=0;

        while(i<n && j>=0){
            int sum=arr1[i]+arr2[j];
            int diff=Math.abs(sum-k);
            if(diff<bestdiff){
                bestdiff=diff;
                bestI=i;
                bestJ=j;
            }
            if(sum>k){
                j--;
            }
            else{
                i++;
            }
        }

        System.out.println((bestI+1)+" "+(bestJ+1));


    }
}
