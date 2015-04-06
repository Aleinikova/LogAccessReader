package logfile;

import java.util.ArrayList;
import java.util.Date;

public interface ILargestSize {
	
	public int LargestSize (ArrayList<LogFileRecord> listLogRecord, Date before,Date after);

}
