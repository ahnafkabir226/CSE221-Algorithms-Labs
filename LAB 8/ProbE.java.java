import java.io.*;
import java.util.*;
public class ProbE {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int[] s=new int[n];
        int[] e=new int[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            s[i]=Integer.parseInt(st.nextToken());
            e[i]=Integer.parseInt(st.nextToken());
        }

        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }

        Arrays.sort(idx,(a,b)->Integer.compare(e[a],e[b]));

        ArrayList<Integer> result=new ArrayList<>();
        int lastend=-1;

        for(int i=0;i<n;i++){
            int curr=idx[i];

            if(s[curr]>lastend){
                result.add(curr);
                lastend=e[curr];
            }
        }

        out.println(result.size());

        for(int i=0;i<result.size();i++){
            int j=result.get(i);
            out.println(s[j]+" "+e[j]);
        }

        out.close();

    }
}