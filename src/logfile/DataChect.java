package logfile;

public class DataChect {

	public boolean DataChecer(Parametrs params) 
	{
		if ((params.logRecord.getTime()).after(params.before)&&(params.logRecord.getTime()).before(params.after))
			return true;
		else 
			return false;
	}

}
