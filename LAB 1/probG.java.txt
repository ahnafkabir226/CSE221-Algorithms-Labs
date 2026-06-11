import java.util.Scanner;
public class probG {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for(int i=0;i<T;i++){
            int N=scanner.nextInt();
            int[] id=new int[N];
            int[] marks=new int[N];
            for(int j=0;j<N;j++){
                id[j]=scanner.nextInt();
            }
            for(int j=0;j<N;j++){
                marks[j]=scanner.nextInt();
            }

            int count=0;
            
            for(int a=0;a<N-1;a++){
                int idx=a;
                for(int b=a+1;b<N;b++){
                    if(marks[b]>marks[idx]){
                        idx=b;
                    }
                    else if(marks[b]==marks[idx]){
                        if(id[b]<id[idx]){
                            idx=b;
                        }
                    }
                }

                if(idx!=a){
                    int t1=marks[a];
                    marks[a]=marks[idx];
                    marks[idx]=t1;
                    int t2=id[a];
                    id[a]=id[idx];
                    id[idx]=t2;

                    count++;
                }

            }

            System.out.println("Minimum swaps: "+count);
            for(int j=0;j<N;j++){
                System.out.println("ID: "+id[j]+" Mark: "+marks[j]);
            }

        }
    }
}
