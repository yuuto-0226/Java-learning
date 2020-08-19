package AI00;
import java.util.Scanner;
public class perceptronTest {
	private double e;//閥值
	private double w;//權術
	private double[] rate;//正確率(%)
	private int count;//次數
	private double Eta=0.005;//學習速率
	private int x;//輸入值
	
	public void set(double[] rate,int count) {
		this.e=0;
		this.w=0;
		this.count=count;
		this.rate rate=new double[count];
	}
	
	public static double sigMoid(double net) {
        //Math.E=e;Math.Pow(a,b)=a^b
        double a=Math.pow(Math.E,-net);
        double result=1/(1+a);
        return result;
    }
	//修正權值
	public double bias(int x,double net) {
		double update;
		return update=Eta*(fuc(net)-(double)x);
	}
	//求和函數，輸出值即為net
	public double net(int x) {
		return x*w-e;
	}
	//激發函數，輸出值即為Y
	public double fuc(double net) {
		return sigMoid(net);
	}
	
	
	public static void main(String[] args) {
		
	}
}