import java.util.Scanner;
public class probB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<T;i++){
            String s=scanner.nextLine();
            String a="";
            int j=10;
            while(s.charAt(j)!=' '){
                a+=s.charAt(j);
                j++;
            }
            char op=s.charAt(++j);
            j+=2;
            String b="";
            for(int k=j;k<s.length();k++){
                b+=s.charAt(k);
            }

            double x=Float.parseFloat(a);
            double y=Float.parseFloat(b);
            double res;
            
            if(op=='+'){
                res=x+y;
                System.out.println(res);
            }
            else if(op=='-'){
                res=x-y;
                System.out.println(res);
            }
            else if(op=='*'){
                res=x*y;
                System.out.println(res);
            }
            else if(op=='/'){
                res=x/y;
                System.out.println(res);
            }


        }
        scanner.close();
        
    }
}
