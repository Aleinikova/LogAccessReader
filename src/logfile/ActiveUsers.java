package logfile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ActiveUsers implements IActiveUsers {

	@Override
	public ArrayList<MyMap> users(ArrayList<LogFileRecord> listLogRecord,
			Date before, Date after) {

		ArrayList<MyMap> list = new ArrayList<MyMap>();
		MyMap mapusers;
		for (int i = 0; i < listLogRecord.size(); i++) {
			 mapusers = new MyMap();

			if ((listLogRecord.get(i).getTime()).after(before)
					&& (listLogRecord.get(i).getTime()).before(after)) {
				
				if (mapusers.containsKey(listLogRecord.get(i).getHost(), list)) {
					mapusers.setValue(listLogRecord.get(i).getHost(), list);
				} else {
					mapusers.setKey(listLogRecord.get(i).getHost());
					mapusers.setValue(1);
					list.add(mapusers);
				}

			}
			
		}

		Collections.sort(list);
		
		return list;
	}

}
