
import java.util.Scanner;
public class probH {
    public static void main(String[] args) {
        Scanner scannner= new Scanner(System.in);
        int N=scannner.nextInt();
        scannner.nextLine();
        String[] arr=new String[N];
        String[] name=new String[N];
        int[][] time=new int[N][2];

        for(int i=0;i<N;i++){
            arr[i]=scannner.nextLine();
            String[] words=arr[i].split(" ");
            name[i]=words[0];
            String[] t=words[6].split(":");
            time[i][0]=Integer.parseInt(t[0]);
            time[i][1]=Integer.parseInt(t[1]);
        }

        for(int i=0;i<N-1;i++){
            for(int j=0;j<N-i-1;j++){
                boolean swap=false;
                
                int comp=compare(name[j],name[j+1]);
                if(comp>0){
                    swap=true;
                }
                else if(comp==0){
                    if(time[j][0]<time[j+1][0]){
                        swap=true;
                    }
                    else if(time[j][0]==time[j+1][0]){
                        if(time[j][1]<time[j+1][1]){
                            swap=true;
                        }
                    }
                }



                if(swap){
                    String tname=name[j];
                    name[j]=name[j+1];
                    name[j+1]=tname;

                    String tarr=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tarr;

                    int t1=time[j][0];
                    time[j][0]=time[j+1][0];
                    time[j+1][0]=t1;

                    int t2=time[j][1];
                    time[j][1]=time[j+1][1];
                    time[j+1][1]=t2;
                }
            }
        }


        for(int i=0;i<N;i++){
            System.out.println(arr[i]);
        }



    }

    public static int compare(String s1,String s2){
        int l1=s1.length();
        int l2=s2.length();
        int d=Math.min(l1, l2);

        for(int i=0;i<d;i++){
            int p1=priority(s1.charAt(i));
            int p2=priority(s2.charAt(i));
            if(p1!=p2){
                return p1-p2;
            }
        }

        return l1-l2;
    }

    public static int priority(char c){
        if(c>='a' && c<='z'){
            return c-'a';
        }
        if(c>='A' && c<='Z'){
            return (int)(c-'A')+26;
        }

        return c;
    }

}
