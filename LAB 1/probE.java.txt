import java.util.Scanner;
public class probE {
    public static void main(String[] args) {
        Scanner scanner=new Scanner((System.in));
        int N=scanner.nextInt();
        int[] arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
        }
        
        int[][] moves=new int[N*N][2];
        int count=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N-2;j++){
                if(arr[j]>arr[j+2]){
                    int temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;

                    moves[count][0]=j+1;
                    moves[count][1]=j+3;
                    count++;
                }
            }
        }


        boolean flag=true;
        for(int i=0;i<N-1;i++){
            if(arr[i]>arr[i+1]){
                flag=false;
                break;
            }
        }
        
        if(flag){
            System.out.println("YES");
            System.out.println(count);
            for(int i=0;i<count;i++){
                System.out.println(moves[i][0]+" "+moves[i][1]);
            }
        }
        else{
            System.out.println("NO");
        }



    }
}
