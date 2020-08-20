import java.util.Scanner;
public class perceptronTest {
	private static double e;//閥值
	private static double w;//權術
	private static float[] rate;//正確率(%)
	private static int count;//次數
	private static double Eta=0.005;//學習速率
	private int x;//輸入值
	
	public perceptronTest(float rate,int count) {
		this.e=0;
		this.w=0;
		this.x=0;
		this.count=count;
		this.rate=new float[count];
	}
	//學習，samples[][0] 輸入,samples[][1] 輸出
	public static void fit(int[][] samples) {
		for(int i=0;i<count;i++) {
			int erroCount=0;
			for(int[] sample:samples) {
				double update=Eta*(sample[1]-sample[0]);
				
				w+=update*sample[0];
				e+=update;
			}
			rate[i]=1-erroCount*1.0f/samples.length;
		}
	}
	//sigMoid函數
	public static double sigMoid(double net) {
        //Math.E=e;Math.Pow(a,b)=a^b
        double a=Math.pow(Math.E,-net);
        double result=1/(1+a);
        return result;
    }
	//求和函數，輸出值即為net
	public static double net(int x) {
		return x*w-e;
	}
	//激發函數，輸出值即為Y
	public static double fuc(int x) {
		return net(x)>=0?0:1;
	}
	//修正權值
	public double bias(int x,double net) {
		double update;
		return update=Eta*(fuc(x)-(double)x);
	}
	//印出修正
	public static void printRate() {
		for(int i=0;i<count;i++)
			System.out.print("[#"+i+"]"+rate[i]+"\n");
	}
		
	//學習樣本
	public static int[][] getStudyData(){
		int[][] data=new int[2000000][2];
		for(int i=-100000,j=100000;i<100000;i++,j++) {
			data[j][0]=i;
			data[j][1]=(i>=0)?1:0;//-10000~10000間>0輸出1反之輸出0
		}
		return data;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		perceptronTest perceptron=new perceptronTest(0.0000005f,100);
		perceptronTest.fit(getStudyData());
		perceptronTest.printRate();
		while(true) {
		System.out.print("[#]  ");
		int x=sc.nextInt();
		
		System.out.println("[#]"+perceptronTest.fuc(x));
		}
	}
}
