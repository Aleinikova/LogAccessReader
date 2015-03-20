
public class Log {

	String host;
	String time;
	String request;
	int code;
	int size;
	
	public void Print()
	{
		System.out.println(host);
		System.out.println(time);
		System.out.println(request);
		System.out.println(code);
		System.out.println(size);
	}

}
