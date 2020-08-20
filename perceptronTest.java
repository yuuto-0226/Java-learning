package AI00;
import java.util.Scanner;
public class perceptronTest {
	private static float T;//預估值
	private static float Y;//激發函數輸出值
	private float x;//輸入值
	private static float w;//權值
	private static float theta;//閥值
	private static float eta;//學習速率
	private static float bias;//修正值
	private static float rate;//正確率
	private static int count;//錯誤計數
	//設定初始值
	public perceptronTest() {
		this.theta=0;
		this.w=0;
		this.bias=0;
		this.rate=0;
		this.count=0;
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
			T=(Data>0)?Data:0;	//預估值
			bias=eta*(T-Y)*Data;
			
			w+=bias;
			theta+=bias/Data;
			
			rate=Y/T*1.00f;
			
			count++;
			
			System.out.println("[AI]#"+count+" >> "+rate);
		}
	}
	
	//設定資料庫
	public static int Data(int max,int min) {
		int data=(min-1)+(int)(Math.random()*(max-min)+1);
		return data;
	}
	
	
	public static void main(String[] args) {
		fit(Data(100,-100));
	}
}
