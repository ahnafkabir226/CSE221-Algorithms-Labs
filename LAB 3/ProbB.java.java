import java.io.*;
import java.util.*;
public class ProbB {

    static long count=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        mergediv(arr);


        out.println(count);
        out.close();


    }

    public static int[] mergediv(int[] arr){
        if(arr.length<=1){
            return arr;
        }

        int mid=arr.length/2;
        int[] left=new int[mid];
        int[] right=new int[arr.length-mid];

        for(int i=0;i<mid;i++){
            left[i]=arr[i];
        }

        for(int i=0,j=mid;j<arr.length;i++,j++){
            right[i]=arr[j];
        }

        return MERGE(mergediv(left),mergediv(right));


    }


    public static int[] MERGE(int[] a,int[] b){
        int[] m=new int[a.length+b.length];

        for(int j=0;j<b.length;j++){
            long comp=(long)b[j]*b[j];
            int low=0;
            int high=a.length;
            while(low<high){
                int mid=(low+high)/2;

                if((long)a[mid]>comp){
                    high=mid;
                }
                else{
                    low=mid+1;
                }
            }
            count+=a.length-low;
        }

        


        int i=0;
        int j=0;
        int k=0;


        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                m[k++]=a[i++];
            }
            else{
                m[k++]=b[j++];
            }
        }

        while(i<a.length){
            m[k++]=a[i++];
        }

        while(j<b.length){
            m[k++]=b[j++];
        }

        return m;


    }



}
