import java.util.Scanner;
public class finalcode2 {

	public static void main(String[] args) {
		int in=0,require=0,a=0,b=0,ran=0;
		Scanner fc =new Scanner(System.in);
		System.out.println("[#]設定範圍");
		System.out.printf("[#]初始值: ");
		a=fc.nextInt();
		System.out.printf("[#]終止值: ");
		b=fc.nextInt();
		do {
			ran = (int)(Math.random()*1000000000+1);
			if (ran>=a && ran<=b)
				require = 1;
			else
				require = 0;
		}while(require<1);
		do {
			System.out.printf("[#]請輸入一個數: ");
			//手動
			in=fc.nextInt();
			//自動
			/*for (int i=a+1;i<b;i+=1) {
				in=i;
			}
			System.out.println(in);*/
			if(in==ran) {
				System.out.println("[#]恭喜答對");
				require = 1;
			}
			else if(in<=a||in>=b){
				System.out.println("[#]超出提示範圍");
				System.out.println("[#]數字介於"+a+"~"+b+"之間");
				require = 0;
			}
			else if(in<ran){
				System.out.println("[#]答錯");
				a = in;
				System.out.println("[#]數字介於"+a+"~"+b+"之間");
				require = 0;
			}
			else if(in>ran){
				System.out.println("[#]答錯");
				b = in;
				System.out.println("[#]數字介於"+a+"~"+b+"之間");
				require = 0;
			}
		}while(require<1);
	}
}