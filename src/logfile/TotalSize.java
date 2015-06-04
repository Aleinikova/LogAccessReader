package logfile;


public class TotalSize implements IReportGenerator<Parametrs,Integer> {
	
	private Integer allSize =0;

	@Override
	public void generate(Parametrs params) {

			if ((params.logRecord.getTime()).after(params.before)
					&& (params.logRecord.getTime()).before(params.after)) {
				allSize += params.logRecord.getSize();

			}
	}
	@Override
	public Integer get ()
	{
		return allSize;
	}

}
