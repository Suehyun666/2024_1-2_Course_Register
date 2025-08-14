package main; 

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("서버가 시작되었습니다...");
		Skeleton skeleton = new Skeleton();
		skeleton.initialize();
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
