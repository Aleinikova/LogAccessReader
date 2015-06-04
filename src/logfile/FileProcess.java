package logfile;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
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
			//BufferedReader in = new BufferedReader(new FileReader(path));
			// BufferedWriter out = new BufferedWriter(new FileWriter(pathNew));
			LineNumberReader in = new LineNumberReader(new FileReader(path));
			int j = 1;
			String str;
			LogFileRecord logRecord = new LogFileRecord();
			 MyStream reader = new MyStream();
	            reader.setNumberOfStartLine(line);
	            reader.setQuantityOfStrings(numberLine);
	            //reader.setIn(in);
	            reader.start();
	            
	           while(!reader.isEmpty()) {

	                str = reader.getLine();
	                    try {
	                        logRecord = parser.parse(str);
	                        listLogRecord.add(logRecord);
	                        printer.printRecord(logRecord);
	                        //System.out.println(str);
	                        //System.out.println(logRecord.toString());
	                    }
	                    catch (ArrayIndexOutOfBoundsException e)
	                    {  
	                        //System.out.println("Invalid format of string! Number of string: ");
	                    }
	                    
	            }

			/*while ((str = in.readLine()) != null) {

				if (j >= line && j < line + 10) {
					System.out.println(str);
					//log = parser.parse(str);
					//printer.printRecord(log);
					//listLogRecord.add(log);

				} else if (j == line + 10) {
					break;
				}
				j++;

			}*/
			in.close();

			// out.close();
		} catch (IOException e) {

			System.out.println("File");
		}

		return listLogRecord;

	}

}
