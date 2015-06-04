package logfile;

public interface IReportGenerator<T,K> {

	public void generate (T params);
	public K get ();
}
