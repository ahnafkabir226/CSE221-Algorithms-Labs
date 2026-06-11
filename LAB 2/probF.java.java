import java.util.*;
import java.io.*;
public class probF {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        int[] freq=new int[n+1];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int i=0;
        int bestdis=0;
        int count=0;


        for(int j=0;j<n;j++){
            int val=arr[j];

            if(freq[val]==0){
                count++;
            }
            freq[val]++;


            while(count>k){
                int left=arr[i];
                freq[left]--;

                if(freq[left]==0){
                    count--;
                }
                i++;
            }
            if((j-i+1)>bestdis){
                bestdis=j-i+1;
            }
        }

        out.println(bestdis);
        out.close();



    }
}
