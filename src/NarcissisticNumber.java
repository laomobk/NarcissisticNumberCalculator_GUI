import java.io.*;
import java.util.Date;
public class NarcissisticNumber
{	

	private static  MainWindow win;
	
	public static void getWindow(MainWindow w) {
		win = w;
	}
	
	static int c_cube(char c,int p){
		int n = Integer.parseInt(String.valueOf(c));
		return (int)Math.pow(n,p);
	}
	static boolean isResult(int num,int l){
		char[] buffer = String.valueOf(num).toCharArray();
		int bnum = 0;

		for(char c:buffer){
			bnum += c_cube(c,l);
		}
		if(bnum == num){
			return true;
		}
		else{
			return false;
		}
	}

//	public static void main(String[] a) throws NumberFormatException, IOException{
//		AutoTest.startTest(7);
//	}

	public static void run(int n) throws IOException{
		int num = n;
		log l = new log();
		Timer t = new Timer();
		int time = String.valueOf(num).length() - 1;
		//System.out.println("开始计算"+time+"位！");
		l.out("开始计算"+time+"位！");
		//win.appendText("开始计算"+time+"位！");
		t.start();
		//System.out.println("开始计时！\n");
		l.out("开始计时！\n");
		win.appendText("开始计时！\n");
		for(int i = 0;i <= num;i++){
			if(isResult(i,time)){
				//System.out.println(i);
				win.appendText(String.valueOf(i));
				//System.out.println("====="+t.getSec()+" sec=====");
				l.out("====="+t.getSec()+" sec=====");
				win.appendText("====="+t.getSec()+" sec=====");
			}
		}
		t.Tstop();
		//System.out.println("\n计算完成！");
		//System.out.println("总共用了"+(double)t.getSec()+"秒！");
		l.out("\n计算完成！");
		l.out("总共用了"+(double)t.getSec()+"秒！");
		win.appendText("\n计算完成！");
		win.appendText("总共用了"+(double)t.getSec()+"秒！");
		l.save();
	}
	
}

class Timer extends Thread{
	private double sec;
	private boolean isBreak = false;
	public void run(){
		sec = 0;
		while(!isBreak){
			try
			{
				Thread.sleep(10);
				sec+=0.01;
			}
			catch (InterruptedException e)
			{}
		}
		sec = 0;
	}
	void Tstop(){
		isBreak = true;

	}
	double getSec(){
		return sec;
	}
}

class AutoTest{
	static void startTest(int len) throws NumberFormatException, IOException{
		StringBuffer str = new StringBuffer();
		str.append(1);
		for(int n:new int[len]){
			str.append(0);
		}

		NarcissisticNumber.run(Integer.parseInt(str.toString()));
	}
}

class log{
	private Date date = new Date();
	private File f;
	private FileWriter fw;
	private BufferedWriter br;

	log() throws IOException{
		f = new File("console.txt");
		fw = new FileWriter(f);
		br = new BufferedWriter(fw);
	}

	void out(String str){
		try
		{
			br.write(date.toString()+" => "+ str + "\n");
		}
		catch (IOException e)
		{}
	}
	void save(){
		try
		{
			br.flush();
			br.close();
			fw.close();
		}
		catch (IOException e)
		{}
	}
	
}
