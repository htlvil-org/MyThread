package pkgThread;

public class ThDog implements Runnable {
	private static final int  MAX_SLEEP = 4000;
	private String 	nameDog = null;
	private int 	from = 0, 
					to = 0;

	//new comment - 1 - 
	public ThDog(String nameDog, int from, int to) {
		super();
		this.nameDog = nameDog;
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		try {
			for (int i= from; i<= to; i++) {
				System.out.println("..       " + this.getClass().getName() + " " + nameDog + i);
				Thread.sleep((long)(Math.random()*MAX_SLEEP));
			}
		}
		catch (Exception ex) {
			System.out.println("=========== error in " + nameDog + "; " + ex.getMessage());
		}
		System.out.println("== " + nameDog + " stopped");
	}
}
