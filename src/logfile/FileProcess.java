package logfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileProcess implements IFileProcess {

	private IParseRecord parser = new ParseRecord();
	private IRecordPrinter printer = new RecordPrinter();

	public FileProcess(IParseRecord parser, IRecordPrinter printer) {
		this.parser = parser;
		this.printer = printer;
	}

	@Override
	public ArrayList<LogFileRecord> readLine(String path, int line,
			int numberLine) {

		ArrayList<LogFileRecord> listLogRecord = new ArrayList<LogFileRecord>();

		try {

			// pathNew = "C:\\Users\\g6\\Documents\\Eclipse\\logReader\\bin\\"+
			// nameNewFile;
			BufferedReader in = new BufferedReader(new FileReader(path));
			// BufferedWriter out = new BufferedWriter(new FileWriter(pathNew));
			int j = 1;
			String s;
			LogFileRecord log = new LogFileRecord();

			while ((s = in.readLine()) != null) {

				if (j >= line && j < line + numberLine) {
					log = parser.parse(s);
					printer.printRecord(log);
					listLogRecord.add(log);

				} else if (j == line + numberLine) {
					break;
				}
				j++;

			}
			in.close();

			// out.close();
		} catch (IOException e) {

			System.out.println("File");
		}

		return listLogRecord;

	}

}
