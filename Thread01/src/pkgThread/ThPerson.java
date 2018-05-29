package pkgThread;

public class ThPerson extends Thread {
	private static final int  MAX_SLEEP = 4000; //msec
	private String namePerson = null;
	private int from = 0, to = 0;
	private boolean isEnd = false;

	public ThPerson(String namePerson, int from, int to) {
		super();
		this.namePerson = namePerson;
		this.from = from;
		this.to = to;
	}
	public void setEnd() {
		isEnd = true;
	}
	@Override
	public void run() {
		try {
			for (int i = from; i <= to  && ! isEnd; i++) {
				System.out.println("....       " + this.getClass().getName()
						+ " " + namePerson + i);
				sleep((long) (Math.random() * MAX_SLEEP)); //interrupts thread for xx msec
			}
		} catch (Exception ex) {
			System.out.println("=========== error in " + namePerson + "; "
					+ ex.getMessage());
		}
		System.out.println("== " + namePerson + " stopped");
	}

}
