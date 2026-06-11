import java.io.*;
import java.util.*;
public class ProbG {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        String start=st.nextToken();
        String end=st.nextToken();

        ArrayList<String>[] list=new ArrayList[26];
        for(int i=0;i<26;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            String w=br.readLine();
            list[w.charAt(0)-'A'].add(w);
        }

        Queue<String> q=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();

        q.add(start);
        vis.add(start);

        while(!q.isEmpty()){
            String curr=q.poll();

            if(curr.equals(end)){
                out.println("YES");
                out.close();
                return;
            }

            char last=curr.charAt(curr.length()-1);
            int ind=last-'A';

            for(String next:list[ind]){
                if(!vis.contains(next)){
                    vis.add(next);
                    q.add(next);
                }
            }
            list[ind].clear();
        }

        out.println("NO");
        out.close();


    }
}
