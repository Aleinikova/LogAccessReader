package logfile;

import java.io.IOException;
import java.util.ArrayList;

public interface IFileProcess {
	public ArrayList<LogFileRecord> readLine(String name, int line,
			int numberLine)throws IOException;
}
