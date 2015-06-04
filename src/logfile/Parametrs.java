package logfile;

import java.util.ArrayList;
import java.util.Date;

public class Parametrs {

	LogFileRecord logRecord;
	Date before;
	Date after;

	public Parametrs(LogFileRecord logRecord, Date before,
			Date after) {
		this.logRecord = logRecord;
		this.before = before;
		this.after = after;
	}

}
