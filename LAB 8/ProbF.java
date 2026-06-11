import java.io.*;
import java.util.*;
public class ProbF {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int t=Integer.parseInt(st.nextToken());

        while(t-- >0){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

            int[][] tasks=new int[n][2];
            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                tasks[i][0]=Integer.parseInt(st.nextToken());
                tasks[i][1]=Integer.parseInt(st.nextToken());
            }

            Arrays.sort(tasks,(a,b) -> Integer.compare(a[1],b[1]));

            TreeMap<Integer,Integer> ppl=new TreeMap<>();
            ppl.put(-1,m);

            int count=0;
            for(int[] task:tasks){

                Integer early=ppl.lowerKey(task[0]);

                if(early!=null){
                    count++;


                    int personc=ppl.get(early);
                    if(personc==1){
                        ppl.remove(early);
                    }
                    else{
                        ppl.put(early,personc-1);
                    }
                    ppl.put(task[1],ppl.getOrDefault(task[1],0)+1);
                }

            }

            out.println(count);

        }

        out.close();
        



    }
}
