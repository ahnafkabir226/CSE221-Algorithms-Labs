import java.util.Scanner;
public class probD {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for(int i=0;i<T;i++){
            int N=scanner.nextInt();
            int[] arr= new int[N];
            for(int j=0;j<N;j++){
                arr[j]=scanner.nextInt();
            }
            int prev=arr[0];
            boolean flag=true;
            for(int k=0;k<N;k++){
                if(prev>arr[k]){
                    flag=false;
                    break;
                }
                prev=arr[k];
            }
            if(flag){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
