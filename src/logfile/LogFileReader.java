package logfile;
import java.io.IOException;
import java.util.ArrayList;

public class LogFileReader {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String name = args[0];
		String path = "C:\\Users\\g6\\Documents\\Eclipse\\logReader\\bin\\" + name;
		int line = Integer.parseInt(args[1]);
		int numberLine = Integer.parseInt(args[2]);
		//String nameNewFile = args[3];
		IRecordPrinter printer = new RecordPrinter();
		IParseRecord parser = new ParseRecord();
		IFileProcess process = new FileProcess(parser,printer);
		ArrayList<LogFileRecord> listLogRecord = new ArrayList<LogFileRecord>();
		listLogRecord = process.readLine(path, line, numberLine);
		
	}

}
