package logfile;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class LogFileReader {
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		String name = args[0];
		// String path =
		// "C:\\Users\\g6\\Documents\\Eclipse\\logReader\\bin\\access_log_Jul95.txt";
		// + name;
		int line = Integer.parseInt(args[1]);
		int numberLine = Integer.parseInt(args[2]);
		SimpleDateFormat format = new SimpleDateFormat(
				"dd/MMMM/yyyy:HH:mm:ss ZZ", Locale.ENGLISH);
		Date before = format.parse(args[3] + " " + args[4]);
		Date after = format.parse(args[5] + " " + args[6]);
		MyStream reader = new MyStream();
		reader.setNumberOfStartLine(line);
		reader.setQuantityOfStrings(numberLine);
		reader.setIn(name);
		reader.start();
		int numberReport = Integer.parseInt(args[7]);
		// String nameNewFile = args[3];
		/*
		 * IRecordPrinter printer = new RecordPrinter(); ParseRecord parser =
		 * new ParseRecord(); IFileProcess process = new FileProcess(parser,
		 * printer);
		 * 
		 * ArrayList<LogFileRecord> listLogRecord = new
		 * ArrayList<LogFileRecord>(); listLogRecord = process.readLine(name,
		 * line, numberLine);
		 * 
		 * Parametrs params = new Parametrs(listLogRecord, before, after);
		 */

		IRecordPrinter printer = new RecordPrinter();
		ParseRecord parser = new ParseRecord();
		ArrayList<LogFileRecord> listLogRecord = new ArrayList<LogFileRecord>();
		Parametrs params ;

		int j = 1;
		String str;
		LogFileRecord logRecord = new LogFileRecord();
		DataChect dataChecer = new DataChect();
		IReportGenerator<Parametrs,Integer> totalSize = new TotalSize();
		IReportGenerator<Parametrs,ArrayList<MyMap>> active = new ActiveUsers();
		IReportGenerator<Parametrs,Integer> largestSize= new LargestSize();

		while (!reader.isEmpty()) {

			str = reader.getLine();

			logRecord = parser.parse(str);
			listLogRecord.add(logRecord);
			// printer.printRecord(logRecord);
			// System.out.println(str);
			// System.out.println(logRecord.toString());
			params = new Parametrs(logRecord, before, after);
			if (dataChecer.DataChecer(params))
			{
				totalSize.generate(params);
				active.generate(params);
				largestSize.generate(params);
			}

		}

		System.out.println(listLogRecord.size());
		
		switch (numberReport) {
		case 1: {
			//IReportGenerator<Parametrs, ArrayList<MyMap>> report = new ActiveUsers();

			System.out.println("From [" + before.toString() + "] To ["
					+ after.toString() + "]");
			ArrayList<MyMap> mapp = active.get();
			//int n = 5;
			//if (mapp.size() < 5)
				//n = mapp.size();
			for (int i = 0; i < mapp.size(); i++) {
				System.out.println(mapp.get(i).toString());
			}
			break;
		}
		case 2: {
			//IReportGenerator<Parametrs, Integer> report = new TotalSize();
			//System.out.println(report.generate(params));
			System.out.println(largestSize.get());
			break;
		}
		case 3: {
			//IReportGenerator<Parametrs, Integer> report = new LargestSize();
			//System.out.println(report.generate(params));
			System.out.println(totalSize.get());
			break;
		}
		}

	}
}
