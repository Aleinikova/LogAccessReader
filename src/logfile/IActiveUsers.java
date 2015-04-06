package logfile;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public interface IActiveUsers {

	public ArrayList<MyMap> users(ArrayList<LogFileRecord> lisLogRecord,
			Date befor, Date after);

}
