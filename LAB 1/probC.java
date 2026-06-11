import java.util.Scanner;
public class probC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long T=scanner.nextInt();
        for(int i=0;i<T;i++){
            long N=scanner.nextInt();
            long sum=(N*(N+1))/2;
            System.out.println(sum);
        }
    }
}
