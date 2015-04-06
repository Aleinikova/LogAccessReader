package logfile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class LogFileReader {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		String name = args[0];
		String path = "C:\\Users\\g6\\Documents\\Eclipse\\logReader\\bin\\"
				+ name;
		int line = Integer.parseInt(args[1]);
		int numberLine = Integer.parseInt(args[2]);
		SimpleDateFormat format = new SimpleDateFormat(
				"dd/MMMM/yyyy:HH:mm:ss ZZ", Locale.ENGLISH);
		Date before = format.parse(args[3] + " " + args[4]);
		Date after = format.parse(args[5] + " " + args[6]);
		// String nameNewFile = args[3];

		IRecordPrinter printer = new RecordPrinter();
		IParseRecord parser = new ParseRecord();
		IFileProcess process = new FileProcess(parser, printer);

		ArrayList<LogFileRecord> listLogRecord = new ArrayList<LogFileRecord>();

		listLogRecord = process.readLine(path, line, numberLine);

		IActiveUsers user = new ActiveUsers();
		System.out.println("From ["+ before.toString() + "] To [" + after.toString()+"]");
		ArrayList<MyMap> mapp = user.users(listLogRecord, before, after);
		int n = 5;
		if (mapp.size() < 5)
			n = mapp.size();
		for (int i = 0; i < n; i++) {
			System.out.println(mapp.get(i).toString());
		}
		
		ITotalSize size = new TotalSize();
		System.out.println(size.sizeAnswer(listLogRecord, before, after));
		
		ILargestSize maxSize = new LargestSize();
		System.out.println(maxSize.LargestSize(listLogRecord, before, after));

	}

}
