public class Exercise1 {
	public static void main(String[] args) throws Exception {
		Object lock = new Object();

		Thread t1 = new WordPrintingThread("Hello", lock);
		Thread t2 = new WordPrintingThread("World", lock);

		// Thread t1 = new CharPrintingThread("Hello", lock);
		// Thread t2 = new CharPrintingThread("World", lock);
		
		// Thread t1 = new ChaoticCharPrintingThread("Hello", lock);
		// Thread t2 = new ChaoticCharPrintingThread("World", lock);
		t1.start();
		t2.start();
	}

}

abstract class TextPrintingThread extends Thread {

	protected String text;
	Object lock;

	public TextPrintingThread(String text, Object lock) {
		this.text = text;
		this.lock = lock;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			myPrintLn();
		}
	}

	abstract void myPrintLn();
}

class WordPrintingThread extends TextPrintingThread {

	public WordPrintingThread(String text, Object lock) {
		super(text, lock);
	}

	@Override
	public void myPrintLn() {
		synchronized (lock) {
			try {
				sleep(1);
			} catch (Exception e) {
			}
		}
		System.out.println(text);
	}
}

class CharPrintingThread extends TextPrintingThread {

	public CharPrintingThread(String text, Object lock) {
		super(text, lock);
	}

	@Override
	public void myPrintLn() {
		synchronized (lock) {
			for (char c : text.toCharArray()) {
				try {
					sleep(50);
				} catch (Exception e) {
				}
				System.out.print(c);
			}
		}
		System.out.println();
	}
}

class ChaoticCharPrintingThread extends TextPrintingThread {

	public ChaoticCharPrintingThread(String text, Object lock) {
		super(text, lock);
	}

	@Override
	public void myPrintLn() {
		for (char c : text.toCharArray()) {
			synchronized (lock) {
				try {
					sleep(1);
				} catch (Exception e) {
				}
			}
			System.out.print(c);
		}
		System.out.println();
	}
}