package pkgMain;

import pkgThread.ThDog;
import pkgThread.ThPerson;

public class MainApp {
	//comment
	private static ThPerson pth1 = new ThPerson("Ameise", 10, 15),
							pth2 = new ThPerson("Bmeise", 15, 20);
	private static Thread 	dth1 = new Thread(new ThDog("Lucky", 10, 16)),
							dth2 = new Thread(new ThDog("Lassy", 21, 26));
	
	public static void main(String[] args) {
		try {
			startThreads();
			getState();
			setEnd();
			awaitThreads();
			getState();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("== main thread stopped");
	}

	private static void setEnd() {
		pth1.setEnd();
		pth2.setEnd();
		
	}

	private static void getState() {
		System.out.println("### " + pth1.getId() + ", " + pth1.getState());
		System.out.println("### " + pth2.getId() + ", " + pth2.getState());
		System.out.println("### " + dth1.getId() + ", " + dth1.getState());
		System.out.println("### " + dth2.getId() + ", " + dth2.getState());
	
	}

	private static void startThreads() {
		pth1.start();
		pth2.start();

		dth1.start();
		dth2.start();
	}

	private static void awaitThreads() throws InterruptedException {
		pth1.join();	//stop main process till thread ends
		System.out.println("---main thread continues, because pth1 terminated");
		pth2.join();
		dth1.join();
		dth2.join();
	}

}
