package logfile;

import java.util.ArrayList;
import java.util.Collections;

public class LargestSize implements IReportGenerator<Parametrs,Integer> {
	private int largestSize;
	
	@Override
	public Integer get ()
	{
		return largestSize;
	}
	public void generate(Parametrs params) {
		
		ArrayList<MyMap> list = new ArrayList<MyMap>();
		MyMap mapusers = new MyMap();

		if (params.logRecord.getSize()>largestSize)
			largestSize = params.logRecord.getSize();
		
	}

}
