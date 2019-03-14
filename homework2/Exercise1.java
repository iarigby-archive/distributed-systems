public class Exercise1 {
	public static void main(String[] args) throws Exception {
		Object lock = new Object();

		/* Make a application with two threads.
			Let one thread print the text "Hello" 10000 times on separate lines,
			and let the other print "World".*/
		Thread t1 = new WordPrintingThread("Hello", lock);
		Thread t2 = new WordPrintingThread("World", lock);
		
		/* Now do the same, but make the threads 
		print the texts character by character.*/
		// Thread t1 = new ChaoticCharPrintingThread("Hello", lock);
		// Thread t2 = new ChaoticCharPrintingThread("World", lock);
		
		/* Keeping the character by character printing, fix 1b. */
		// Thread t2 = new CharPrintingThread("World", lock);
		// Thread t1 = new CharPrintingThread("Hello", lock);

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
		try {
			sleep(1);
		} catch (Exception e) {
		}
		synchronized (lock) {
			System.out.println(text);
		}
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
					sleep(1);
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
			try {
				sleep(1);
			} catch (Exception e) {
			}
			synchronized (lock) {
				System.out.print(c);
			}
		}
		System.out.println();
	}
}