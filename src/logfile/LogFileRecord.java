package logfile;

import java.util.Date;



public class LogFileRecord {

	private String host;
	private Date time;
	private String request;
	private int code;
	private int size;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date date) {
		this.time = date;
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
