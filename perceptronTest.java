import java.util.*;
public class perceptronTest {
	private static float T;//預估值
	private static float Y;//激發函數輸出值
	private static float x;//輸入值
	private static float w;//權值
	private static float theta;//閥值
	private static float eta;//學習速率
	private static float bias;//修正值
	private static int[] rate;//正確率
	private static int count;//錯誤計數
	private static Scanner sc;//輸入
	
	//設定初始值
	public perceptronTest() {
		theta=0;
		w=0;
		bias=0;
		rate=new int[1000000000];
		count=0;
		eta=0.5f;
	}
	
	//求和函數(ΣXi*Wi-θ)
	public static float sigma(int x) {
		float net=x*w-theta;
		return net;
	}
	
	//激發函數
	public static float actFunc(float net) {
		Y=(net>=0)?net:0;
		return Y;
	}
	
	//學習區塊
	public static void fit(int Data) {
		while(bias!=0) {
			Y=actFunc(sigma(Data));	//激發函數輸出值
			T=(Data>0)?1:0;	//預估值
			bias=eta*(T-Y)*Data;
			
			w+=bias;
			theta+=bias/Data;
			
			rate[count]=(int)(Y/T*100);
			
			count++;
			
			System.out.println("[AI]#"+count+" >> "+rate[count]);
		}
	}
	
	//設定資料庫
	public static int Data(int max,int min) {
		int data=(min-1)+(int)(Math.random()*(max-min)+1);
		return data;
	}
	//印出
	public void printPer() {

	}
	
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("[#] ");
		x=sc.nextInt();
		fit(Data(100,-100));
		actFunc(sigma((int)x));
	}
}
