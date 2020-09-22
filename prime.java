import java.util.Scanner;
public class prime{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
	            System.out.println(w.judge(num) ? "質數" : "非質數");
	        }
    }
    public static boolean judge(int num) {
        if (num==2||num==3) {
            return true;
        } else if(num>4) {
            final int m=num%6;
            if (m!=1&&m!=5) {
                return false;
            }
            final int nSqrt=(int) Math.floor(Math.sqrt(num));
            for(int i=5;i<=nSqrt;i+=6) {
                if(num%i==0||num%(i+2)==0) {
                    return false;
                }
            }    
            return true;
        } else {
            return false;
        }
    }
}