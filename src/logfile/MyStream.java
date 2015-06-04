package logfile;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.Queue;

public class MyStream extends Thread {

	private boolean finish = false;
	private String path;
	private int quantityOfStrings;
	private int numberOfStartLine;
	private Queue<String> lines = new LinkedList<String>();

	public void setIn(String path) {
		this.path = path;
	}

	public void setNumberOfStartLine(int numberOfStartLine) {
		this.numberOfStartLine = numberOfStartLine;
	}

	public void setQuantityOfStrings(int quantityOfStrings) {
		this.quantityOfStrings = quantityOfStrings;
	}

	public void run() {
		String str = "";
		
		//try {
			try {
				LineNumberReader in = new LineNumberReader(new FileReader(path));
				for (int i = 1; (str = in.readLine()) != null
						&& i < quantityOfStrings + numberOfStartLine; i++) {
					if (i >= numberOfStartLine) {
						if (lines.size() < 60000)
							lines.add(str);
						else {
							try {
								sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							lines.add(str);
						}
					}
				}
			
		} catch (IOException e) {
			System.out.println("Говнищеееееееее!");
		}
	}

	public String getLine() {
		return lines.poll();
	}

	public boolean isEmpty() {
		return lines.peek() == null;
	}

}
