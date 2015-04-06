package logfile;

import java.util.ArrayList;
import java.util.Date;

public class TotalSize implements ITotalSize {

	@Override
	public int sizeAnswer(ArrayList<LogFileRecord> listLogRecord, Date before,
			Date after) {

		int size = 0;
		for (int i = 0; i < listLogRecord.size(); i++) {

			if ((listLogRecord.get(i).getTime()).after(before)
					&& (listLogRecord.get(i).getTime()).before(after)) {
				size += listLogRecord.get(i).getSize();

			}

		}
		return size;
	}

}
