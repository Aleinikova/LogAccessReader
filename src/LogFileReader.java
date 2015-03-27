import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogFileReader {


	public static LogFileRecord parse(String line) {

		String[] words = line
				.split("(( - - )|( \\[)|(\\])|(\\[)|(\\\"\\s)|( \\\")| (?=-$)| (?=\\d+$))+");

		LogFileRecord log = new LogFileRecord();
		log.setHost(words[0]);
		log.setTime(words[1]);
		log.setRequest(words[2]);
		log.setCode(Integer.parseInt(words[3]));
		log.setSize(Integer.parseInt(words[4]));

		return log;
	}

	public static void printLogFileRecord(LogFileRecord log) {
		System.out.println(log.toString());
	}

	public static void readLine(String name, int line, int numberLine) throws IOException {

		String path, pathNew;
		path = "C:\\Users\\g6\\Documents\\Eclipse\\logReader\\bin\\" + name;
		//pathNew = "C:\\Users\\g6\\Documents\\Eclipse\\logReader\\bin\\"+ nameNewFile;
		BufferedReader in = new BufferedReader(new FileReader(path));
		//BufferedWriter out = new BufferedWriter(new FileWriter(pathNew));
		int j = 1;
		String s;
		LogFileRecord log = new LogFileRecord();
		
		while ((s = in.readLine()) != null) {

			if (j >= line && j < line + numberLine) {
				log = parse(s);
				printLogFileRecord(log);

			} else if (j == line + numberLine) {
				break;
			}
			j++;

		}
		in.close();
		//out.close();

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String name = args[0];
		int line = Integer.parseInt(args[1]);
		int numberLine = Integer.parseInt(args[2]);
		// String nameNewFile = args[3];
		readLine(name, line, numberLine);

	}

}
