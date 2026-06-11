import java.io.*;
import java.util.*;
public class ProbF {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        String s=st.nextToken();
        String tar=st.nextToken();

        int n=Integer.parseInt(br.readLine());
        boolean[] forb=new boolean[10000];
        for(int i=0;i<n;i++){
            forb[toInt(br.readLine())]=true;
        }

        int result=BFS(s,tar,forb);
        out.println(result);
        out.close();
    }


    static int BFS(String s,String tar,boolean[] forb){
        Queue<String> q=new LinkedList<>();
        boolean[] vis=new boolean[10000];

        q.add(s);
        vis[toInt(s)]=true;

        int count=0;
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(curr.equals(tar)){
                    return count;
                }

                for(String next:getN(curr)){
                    int num=toInt(next);

                    if(!vis[num] && !forb[num]){
                        vis[num]=true;
                        q.add(next);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    static List<String> getN(String s){
        List<String> n=new ArrayList<>();
        char[] arr=s.toCharArray();

        for(int i=0;i<4;i++){
            char og=arr[i];

            arr[i]=(char)((og-'0'+1)%10+'0');
            n.add(new String(arr));

            arr[i]=(char)((og-'0'+9)%10+'0');
            n.add(new String(arr));

            arr[i]=og;
        }

        return n;
    }

    static int toInt(String s){
        return Integer.parseInt(s);
    }

}
