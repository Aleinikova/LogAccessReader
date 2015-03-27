public class LogFileRecord {

	private String host;
	private String time;
	private String request;
	private int code;
	private int size;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override 
	public String toString ()
	{
		return host+ " " + time+ " " + " " + request + " " + code + " " + size;
	}
	

}
