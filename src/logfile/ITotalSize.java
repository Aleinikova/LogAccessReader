package logfile;

import java.util.ArrayList;
import java.util.Date;

public interface ITotalSize {
	
	public int sizeAnswer (ArrayList<LogFileRecord> listLogRecord,Date before, Date after);

}
