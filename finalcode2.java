import java.util.Scanner;
public class finalcode2 {

	public static void main(String[] args) {
		int in=0,require=0,a=0,b=0,ran=0;
		Scanner fc =new Scanner(System.in);
		System.out.println("[#]�]�w�d��");
		System.out.printf("[#]��l��: ");
		a=fc.nextInt();
		System.out.printf("[#]�פ��: ");
		b=fc.nextInt();
		do {
			ran = (int)(Math.random()*1000000000+1);
			if (ran>=a && ran<=b)
				require = 1;
			else
				require = 0;
		}while(require<1);
		do {
			System.out.printf("[#]�п�J�@�Ӽ�: ");
			//���
			in=fc.nextInt();
			//�۰�
			/*for (int i=a+1;i<b;i+=1) {
				in=i;
			}
			System.out.println(in);*/
			if(in==ran) {
				System.out.println("[#]���ߵ���");
				require = 1;
			}
			else if(in<=a||in>=b){
				System.out.println("[#]�W�X���ܽd��");
				System.out.println("[#]�Ʀr����"+a+"~"+b+"����");
				require = 0;
			}
			else if(in<ran){
				System.out.println("[#]����");
				a = in;
				System.out.println("[#]�Ʀr����"+a+"~"+b+"����");
				require = 0;
			}
			else if(in>ran){
				System.out.println("[#]����");
				b = in;
				System.out.println("[#]�Ʀr����"+a+"~"+b+"����");
				require = 0;
			}
		}while(require<1);
	}
}