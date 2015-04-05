package logfile;

import java.util.ArrayList;

public interface IFileProcess {
	public ArrayList<LogFileRecord> readLine(String name, int line, int numberLine);
}
