package logfile;

public class RecordPrinter implements IRecordPrinter {

	@Override
	public void printRecord(LogFileRecord log) {
		System.out.println(log.toString());

	}

}
