package logfile;

import java.util.ArrayList;
import java.util.Collections;

public class ActiveUsers implements
		IReportGenerator<Parametrs,ArrayList<MyMap>> {

	private ArrayList<MyMap> list = new ArrayList<MyMap>();

	@Override
	public ArrayList<MyMap> get() {
		Collections.sort(list);
		ArrayList<MyMap> resList = new ArrayList<MyMap>();
		if (list.size() < 3)
			resList = list;
		else {
			resList.add(list.get(0));
			resList.add(list.get(1));
			resList.add(list.get(2));
		}
		return resList;

	}

	@Override
	public void generate(Parametrs params) {

		// ArrayList<MyMap> list = new ArrayList<MyMap>();
		MyMap mapusers = new MyMap();

		if (mapusers.containsKey(params.logRecord.getHost(), list)) {
			mapusers.setValue(params.logRecord.getHost(), list);
		} else {
			mapusers.setKey(params.logRecord.getHost());
			mapusers.setValue(1);
			list.add(mapusers);
		}

	}

}
