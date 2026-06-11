import java.io.*;
import java.util.*;
public class ProbH {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        String[] words=new String[n];

        for(int i=0;i<n;i++){
            words[i]=br.readLine();
        }

        ArrayList<Integer>[] adj=new ArrayList[26];
        for(int i=0;i<26;i++){
            adj[i]=new ArrayList<>();
        }

        int[] indeg=new int[26];
        boolean[] vis=new boolean[26];

        for(String w:words){
            for(char c:w.toCharArray()){
                vis[c-'a']=true;
            }
        }

        for(int i=0;i<n-1;i++){
            String a=words[i];
            String b=words[i+1];

            int l=Math.min(a.length(),b.length());
            boolean flag=false;

            for(int j=0;j<l;j++){
                if(a.charAt(j)!=b.charAt(j)){
                    int u=a.charAt(j)-'a';
                    int v=b.charAt(j)-'a';

                    adj[u].add(v);
                    indeg[v]++;
                    flag=true;
                    break;
                }
            }

            if(!flag && a.length()>b.length()){
                out.println(-1);
                out.close();
                return;
            }
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<26;i++){
            if(vis[i] && indeg[i]==0){
                pq.add(i);
            }
        }

        StringBuilder sb=new StringBuilder();

        while(!pq.isEmpty()){
            int u=pq.poll();
            sb.append((char)(u+'a'));

            for(int v:adj[u]){
                indeg[v]--;
                if(indeg[v]==0){
                    pq.add(v);
                }
            }
        }

        int count=0;
        for(int i=0;i<26;i++){
            if(vis[i]){
                count++;
            }
        }

        if(sb.length()!=count){
            out.println(-1);
        }
        else{
            out.println(sb.toString());
        }

        out.close();



    }
}
