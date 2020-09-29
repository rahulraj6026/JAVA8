
public class Annonymous2 {
	public static void main(String[] args) throws InterruptedException {
		/*Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println(Thread.currentThread().getName());
				}
				
			}
		};*/
		
		Runnable runnable = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		Thread t = new Thread(runnable);
		Thread t1 = new Thread(runnable);
		t.start();
		t.join();
		t1.start();
	}
}
