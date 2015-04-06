package logfile;

import java.util.ArrayList;

public class MyMap implements Comparable<MyMap>,IMyMap {

	private String key;
	private int value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public boolean containsKey(String keys, ArrayList<MyMap> list) {

		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i)).key.matches(keys)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public void setValue(String keys, ArrayList<MyMap> list) {

		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i)).key.matches(keys)) {
				list.get(i).value++;
			}
		}

	}
	@Override
	public int compareTo(MyMap a)
	{
		MyMap b = (MyMap)a;
		
		if (this.value < b.value)
			return 1;
		
		else if (this.value > b.value)
			return -1;
		
		else
			return 0;
	}

	@Override
	public String toString() {
		return key + " " + value;
	}

}
