package AI00;
import java.util.Scanner;
public class perceptronTest {
	private double e;//�֭�
	private double w;//�v�N
	private double[] rate;//���T�v(%)
	private int count;//����
	private double Eta=0.005;//�ǲ߳t�v
	private int x;//��J��
	
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
	//�ץ��v��
	public double bias(int x,double net) {
		double update;
		return update=Eta*(fuc(net)-(double)x);
	}
	//�D�M��ơA��X�ȧY��net
	public double net(int x) {
		return x*w-e;
	}
	//�E�o��ơA��X�ȧY��Y
	public double fuc(double net) {
		return sigMoid(net);
	}
	
	
	public static void main(String[] args) {
		
	}
}