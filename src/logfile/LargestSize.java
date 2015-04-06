package logfile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class LargestSize implements ILargestSize {
	public int LargestSize(ArrayList<LogFileRecord> listLogRecord, Date before,
			Date after) {
		ArrayList<MyMap> list = new ArrayList<MyMap>();
		MyMap mapusers;
		for (int i = 0; i < listLogRecord.size(); i++) {
			mapusers = new MyMap();

			if ((listLogRecord.get(i).getTime()).after(before)
					&& (listLogRecord.get(i).getTime()).before(after)) {

				mapusers.setKey(listLogRecord.get(i).getHost());
				mapusers.setValue(listLogRecord.get(i).getSize());
				list.add(mapusers);

			}
		}
		
		Collections.sort(list);
		return list.get(0).getValue();
	}
	

}
